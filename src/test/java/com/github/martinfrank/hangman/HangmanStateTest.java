package com.github.martinfrank.hangman;

import org.junit.Assert;
import org.junit.Test;

public class HangmanStateTest {

    @Test
    public void test() {
        HangmanState hangmanState = new HangmanState();
        for (int i = 0; i <= 9; i++) {
            System.out.println("i = " + i);
            hangmanState.show(System.out);
            System.out.println();
            System.out.println();
            Assert.assertFalse(hangmanState.isDead());
            hangmanState.nextState();
        }
        hangmanState.show(System.out);
        System.out.println();
        System.out.println();
        Assert.assertTrue(hangmanState.isDead());
    }
}
