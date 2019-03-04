package de.elite.games.hangman;

import org.junit.Test;

public class HangmanTest {

    @Test
    public void test() {
        HangmanState hangmanState = new HangmanState();
        for (int i = 0; i < 11; i++) {
            System.out.println("i = " + i);
            hangmanState.show(System.out);
            System.out.println();
            System.out.println();
            hangmanState.nextState();
        }
    }
}
