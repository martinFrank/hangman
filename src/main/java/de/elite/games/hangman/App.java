package de.elite.games.hangman;

import de.elite.games.cli.CommandLineInterpreter;

public class App {

    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        CommandLineInterpreter commandLineInterpreter = new CommandLineInterpreter(hangman, System.in, System.out);
        commandLineInterpreter.start();
    }
}
