package com.github.martinfrank.hangman;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    public void testCommandList() {
        Hangman hangman = new Hangman(System.out);
        hangman.setup("Test");
        Assert.assertEquals(4, hangman.getCommands().asList().size());
    }

    @Test
    public void testResponse() {
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

    @Test
    public void testLetterCommand() {
        Hangman hangman = new Hangman(System.out);
        Optional<Command> letterCommand = hangman.getCommands().asList().stream().filter(c -> c.isIdentifier("letter")).findAny();
        if (letterCommand.isPresent()) {
            Response emptyResponse = letterCommand.get().execute(Collections.emptyList());
            Assert.assertTrue(emptyResponse.failed());

            List<String> tooMuchLetter = Arrays.asList("a", "b");
            Response tooMuchLetterResponse = letterCommand.get().execute(tooMuchLetter);
            Assert.assertTrue(tooMuchLetterResponse.failed());

            List<String> tooLongLetter = Collections.singletonList("abc");
            Response tooLongLetterResponse = letterCommand.get().execute(tooLongLetter);
            Assert.assertTrue(tooLongLetterResponse.failed());

            List<String> perfectMatch = Collections.singletonList("a");
            Response perfectMatchResponse = letterCommand.get().execute(perfectMatch);
            Assert.assertTrue(perfectMatchResponse.failed());

            hangman.setup("abc");
            perfectMatchResponse = letterCommand.get().execute(perfectMatch);
            Assert.assertFalse(perfectMatchResponse.failed());
        } else {
            Assert.fail();
        }

    }


    @Test
    public void testWordCommand() {
        Hangman hangman = new Hangman(System.out);
        Optional<Command> wordCommand = hangman.getCommands().asList().stream().filter(c -> c.isIdentifier("solve")).findAny();
        if (wordCommand.isPresent()) {
            Response emptyResponse = wordCommand.get().execute(Collections.emptyList());
            Assert.assertTrue(emptyResponse.failed());

            List<String> tooMuchWords = Arrays.asList("abc", "def");
            Response tooMuchWordsResponse = wordCommand.get().execute(tooMuchWords);
            Assert.assertTrue(tooMuchWordsResponse.failed());

            List<String> perfectMatch = Collections.singletonList("abc");
            Response perfectMatchResponse = wordCommand.get().execute(perfectMatch);
            Assert.assertTrue(perfectMatchResponse.failed());

            hangman.setup("abc");
            perfectMatchResponse = wordCommand.get().execute(perfectMatch);
            Assert.assertFalse(perfectMatchResponse.failed());
        } else {
            Assert.fail();
        }
    }

    @Ignore // problems with file access on test server
    @Test
    public void testSetWordCommand() {
        Hangman hangman = new Hangman(System.out);
        Optional<Command> setupCommand = hangman.getCommands().asList().stream().filter(c -> c.isIdentifier("setup")).findAny();
        if (setupCommand.isPresent()) {

            Response TooMuchWordResponse = setupCommand.get().execute(Arrays.asList("abc", "def"));
            Assert.assertTrue(TooMuchWordResponse.failed());

            Response emptyResponse = setupCommand.get().execute(Collections.emptyList());
            Assert.assertFalse(emptyResponse.failed());

            Response singleWordResponse = setupCommand.get().execute(Collections.singletonList("test"));
            Assert.assertFalse(singleWordResponse.failed());
        } else {
            Assert.fail();
        }
    }
}
