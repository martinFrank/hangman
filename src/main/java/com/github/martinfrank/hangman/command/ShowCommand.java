package com.github.martinfrank.hangman.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.hangman.Hangman;

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
