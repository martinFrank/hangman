package com.github.martinfrank.hangman.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.hangman.Hangman;

import java.util.List;

public class HelpCommand extends Command<Hangman> {

    public HelpCommand(Hangman application) {
        super(application, "help");
    }

    @Override
    public Response execute(List<String> parameter) {
        System.out.println("command overview:");
        System.out.println("'help' - shows this help");
        System.out.println("'exit' - terminates the app");
        System.out.println("'setuprandom <n>' - set a renadom word from the list. n is amount of letters of the word");
        System.out.println("'show' - shows the current progress of the game");
        System.out.println("'letter' <c> - try out letter c");
        System.out.println("'solve' <word> - try to solve the word");
        return Response.success();
    }
}
