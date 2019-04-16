package de.elite.games.hangman;

import de.elite.games.cli.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HangManTest {

    @Test
    public void testLetter() {
        Hangman hangman = new Hangman(System.out);
        hangman.setup("Test");

        Assert.assertFalse(hangman.isDead());
        Assert.assertFalse(hangman.isSolved());

        List<String> wrongLetters = Arrays.asList("A", "b", "c", "D", "F", "g", "h", "i", "j", "k");
        for (String letter : wrongLetters) {
            hangman.tryLetter(letter);
        }
        Assert.assertFalse(hangman.isSolved());
        Assert.assertTrue(hangman.isDead());

        hangman.setup("Test");
        Assert.assertFalse(hangman.isDead());
    }

    @Test
    public void testWord() {
        Hangman hangman = new Hangman(System.out);
        hangman.setup("Test");
        Assert.assertFalse(hangman.isDead());
        Assert.assertFalse(hangman.isSolved());
        hangman.tryWord("tEst");
        Assert.assertTrue(hangman.isSolved());
        Assert.assertFalse(hangman.isDead());
    }

    @Test
    public void testCommands() {
        Hangman hangman = new Hangman(System.out);
        hangman.setup("Test");
        Assert.assertEquals(4, hangman.getCommands().asList().size());
    }

    @Test
    public void testResonse() {
        Hangman hangman = new Hangman(System.out);
        Response responseShow = hangman.show();
        Response responseLetter = hangman.tryLetter("a");
        Response responseWord = hangman.tryWord("a");
        Assert.assertTrue(responseShow.failed());
        Assert.assertTrue(responseLetter.failed());
        Assert.assertTrue(responseWord.failed());
        hangman.setup("Test");
        responseShow = hangman.show();
        responseLetter = hangman.tryLetter("a");
        responseWord = hangman.tryWord("a");
        Assert.assertFalse(responseShow.failed());
        Assert.assertFalse(responseLetter.failed());
        Assert.assertFalse(responseWord.failed());
    }
}
