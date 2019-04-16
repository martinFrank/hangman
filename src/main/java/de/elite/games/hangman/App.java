package de.elite.games.hangman;

import de.elite.games.cli.CommandLineInterpreter;

import java.io.PrintStream;

public class App {

    public static void main(String[] args) {
        @SuppressWarnings("squid:S106") //we're NOT logging exceptions into here, it's an console app
                PrintStream out = System.out;
        Hangman hangman = new Hangman(out);
        CommandLineInterpreter commandLineInterpreter = new CommandLineInterpreter(hangman, System.in, out);
        commandLineInterpreter.start();
    }
}
