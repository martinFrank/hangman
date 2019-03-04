package de.elite.games.hangman.command;

import de.elite.games.cli.Command;
import de.elite.games.cli.Response;
import de.elite.games.hangman.Hangman;

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
