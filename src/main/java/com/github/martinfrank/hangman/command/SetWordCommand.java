package com.github.martinfrank.hangman.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.hangman.Hangman;

import java.util.List;

public class SetWordCommand extends Command<Hangman> {

    public SetWordCommand(Hangman hangman) {
        super(hangman, "setup");
    }

    @Override
    public Response execute(List<String> parameters) {
        String word = null;
        if (parameters.size() == 1) {
            word = parameters.get(0).toUpperCase();
        }
        if (parameters.size() > 1) {
            return Response.fail("too much words for hangman - only ONE word is allowed");
        }
        if (parameters.isEmpty()) {
            return Response.fail("you have to provide a word to setup hangman");
        }
        getApplication().setup(word);
        return Response.success();
    }
}
