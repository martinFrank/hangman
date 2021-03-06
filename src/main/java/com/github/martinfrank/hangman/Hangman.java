package com.github.martinfrank.hangman;

import com.github.martinfrank.cli.CommandInterpreter;
import com.github.martinfrank.cli.CommandInterpreterProvider;
import com.github.martinfrank.cli.Response;

import java.io.PrintStream;
import java.util.Optional;

public class Hangman implements CommandInterpreterProvider {

    private final HangmanCommandProvider commandProvider;
    private Word word;
    private Letters letters = new Letters();
    private HangmanState hangmanState;
    private final PrintStream out;
    private WordReader wordReader;

    private final CommandInterpreter commandInterpreter;
    Hangman(PrintStream out) {
        commandProvider = new HangmanCommandProvider(this);
        commandInterpreter = new CommandInterpreter(commandProvider);

        this.out = out;
        setWordReader(new WordReader("./words.txt"));
    }

    @Override
    public void stopCli() {
        commandInterpreter.stop();
    }

    @Override
    public void startCli() {
        commandInterpreter.start();
    }

    @Override
    public CommandInterpreter getCommandInterpreter() {
        return commandInterpreter;
    }

    public Response show() {
        if (word == null) {
            return Response.fail("word is not defined");
        }
        hangmanState.show(out);
        out.println();
        out.println("WORD: " + word.show(letters));
        if (isDead()) {
            out.println("SOLUTION: " + word.show());
        }
        out.println("LETTERS: " + letters.show());
        if (isSolved()) {
            out.println("Congratulations - you did it!!");
        } else {
            if (isDead()) {
                out.println("you lost this game - thanksfully not your life");
            } else {
                out.println("not there yet - try some more letter");
            }
        }
        return Response.success();
    }

    public boolean isDead() {
        return hangmanState.isDead();
    }

    public void setup(String s) {
        word = new Word(s);
        letters.reset();
        hangmanState = new HangmanState();
        show();
    }

    public Response tryLetter(String letter) {
        Optional<Response> check = checkConditions("letters");
        if (check.isPresent()) {
            return check.get();
        }
        if (letters.contains(letter)) {
            return Response.fail("tried that letter (" + letter + ") already");
        }
        letters.add(letter);
        if (word.mismatches(letter)) {
            hangmanState.nextState();
        }
        show();
        return Response.success();
    }

    public boolean isSolved() {
        return word.isSolved(letters);
    }

    public Response tryWord(String wordTry) {
        Optional<Response> check = checkConditions("words");
        if (check.isPresent()) {
            return check.get();
        }
        Letters tryLetters = new Letters(wordTry);
        if (word.isSolved(tryLetters)) {
            letters.addAll(tryLetters);
        } else {
            hangmanState.nextState();
        }
        show();
        return Response.success();
    }

    private Optional<Response> checkConditions(String message) {
        if (word == null) {
            return Optional.of(Response.fail("word is not defined - run 'setup'"));
        }
        if (isSolved()) {
            return Optional.of(Response.fail("you already won the game"));
        }
        if (isDead()) {
            return Optional.of(Response.fail("you are already dead and cannot try any more " + message));
        }
        return Optional.empty();
    }

    public WordReader getWordReader() {
        return wordReader;
    }

    private void setWordReader(WordReader wordReader) {
        this.wordReader = wordReader;
    }
}
