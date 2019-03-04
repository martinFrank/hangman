package de.elite.games.hangman.command;

import de.elite.games.cli.Command;
import de.elite.games.cli.Response;
import de.elite.games.hangman.Hangman;

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
