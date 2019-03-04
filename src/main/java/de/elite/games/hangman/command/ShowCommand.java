package de.elite.games.hangman.command;

import de.elite.games.cli.Command;
import de.elite.games.cli.Response;
import de.elite.games.hangman.Hangman;

import java.util.List;

public class ShowCommand extends Command<Hangman> {

    public ShowCommand(Hangman hangman) {
        super(hangman, "show");
    }

    @Override
    public Response execute(List<String> parameter) {
        return getApplication().show();
    }
}
