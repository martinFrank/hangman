package de.elite.games.hangman;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HangManTest {

    @Test
    public void doIt() {
        Hangman hangman = new Hangman(System.out);
        hangman.setup("Test");

        Assert.assertFalse(hangman.isDead());

        List<String> wrongLetters = Arrays.asList("A", "b", "c", "D", "F", "g", "h", "i", "j", "k", "l");
        for (String letter : wrongLetters) {
            hangman.tryLetter(letter);
        }

        Assert.assertTrue(hangman.isDead());

        hangman.setup("Test");

        Assert.assertFalse(hangman.isDead());
    }
}
