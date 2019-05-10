package com.github.martinfrank.hangman.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.hangman.Hangman;
import com.github.martinfrank.hangman.WordReader;

import java.util.Collections;
import java.util.List;

public class SetRandomWordCommand extends Command<Hangman> {

    public SetRandomWordCommand(Hangman hangman) {
        super(hangman, "setuprandom");
    }

    @Override
    public Response execute(List<String> parameters) {
        if (parameters.size() != 1) {
            return Response.fail("invalid parameter - you have to provide the length of the random word");
        }
        int length;
        try {
            length = Integer.parseInt(parameters.get(0));
            if (length < 3) {
                return Response.fail("length is too short, mus be 3++");
            }
        } catch (NumberFormatException e) {
            return Response.fail("" + parameters.get(0) + " is not a valid number");
        }
        String word = getRandowmWord(length);
        getApplication().setup(word);
        return Response.success();
    }

    private String getRandowmWord(int length) {
        WordReader wordReader = getApplication().getWordReader();
        List<String> words = wordReader.readAllWordsWithLength(length);
        Collections.shuffle(words);
        return words.get(0);
    }
}
