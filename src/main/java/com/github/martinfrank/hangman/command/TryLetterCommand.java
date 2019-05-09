package com.github.martinfrank.hangman.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.hangman.Hangman;

import java.util.List;

public class TryLetterCommand extends Command<Hangman> {

    public TryLetterCommand(Hangman hangman) {
        super(hangman, "letter");
    }

    @Override
    public Response execute(List<String> parameter) {
        if (parameter.size() != 1 || parameter.get(0).length() != 1) {
            return Response.fail("this is not a letter: " + parameter);
        }
        String letter = parameter.get(0);
        return getApplication().tryLetter(letter);
    }
}
