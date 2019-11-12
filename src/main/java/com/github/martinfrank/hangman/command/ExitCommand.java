package com.github.martinfrank.hangman.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.hangman.Hangman;

import java.util.List;

public class ExitCommand extends Command<Hangman> {

    public ExitCommand(Hangman application) {
        super(application, "exit");
    }

    @Override
    public Response execute(List<String> parameter) {
        getApplication().stopCli();
        return Response.success();
    }
}
