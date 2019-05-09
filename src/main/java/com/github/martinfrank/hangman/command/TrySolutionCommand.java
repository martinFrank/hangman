package com.github.martinfrank.hangman.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.hangman.Hangman;

import java.util.List;

public class TrySolutionCommand extends Command<Hangman> {

    public TrySolutionCommand(Hangman hangman) {
        super(hangman, "solve");
    }

    @Override
    public Response execute(List<String> parameter) {
        if (parameter.size() != 1) {
            return Response.fail("this is not a valid word: " + parameter);
        }
        String word = parameter.get(0);
        return getApplication().tryWord(word);
    }
}
