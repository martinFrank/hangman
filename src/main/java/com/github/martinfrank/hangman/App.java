package com.github.martinfrank.hangman;

public class App {

    public static void main(String[] args) {
        @SuppressWarnings("squid:S106") //we're NOT logging exceptions into here, it's an console app
                Hangman hangman = new Hangman(System.out);
        hangman.getCommandInterpreter().start();
    }
}
