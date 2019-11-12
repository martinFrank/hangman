package com.github.martinfrank.hangman;

import com.github.martinfrank.cli.Response;
import com.github.martinfrank.hangman.command.HelpCommand;
import com.github.martinfrank.hangman.command.SetRandomWordCommand;
import com.github.martinfrank.hangman.command.SetWordCommand;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommandTest {


    @Test
    public void testSetWordCommand() {
        Hangman hangman = new Hangman(System.out);
        SetWordCommand wordCommand = new SetWordCommand(hangman);

        Response emptyResponse = wordCommand.execute(Collections.emptyList());
        Assert.assertTrue(emptyResponse.failed());

        List<String> tooMuchWords = Arrays.asList("abc", "def");
        Response tooMuchWordsResponse = wordCommand.execute(tooMuchWords);
        Assert.assertTrue(tooMuchWordsResponse.failed());

        List<String> perfectMatch = Collections.singletonList("abc");
        Response perfectMatchResponse = wordCommand.execute(perfectMatch);
        Assert.assertFalse(perfectMatchResponse.failed());
    }

    @Test
    public void testSetRandomWordCommand() {
        Hangman hangman = new Hangman(System.out);
        SetRandomWordCommand setRandomWordCommand = new SetRandomWordCommand(hangman);

        Response emptyResponse = setRandomWordCommand.execute(Collections.emptyList());
        Assert.assertTrue(emptyResponse.failed());

        Response TooMuchWordResponse = setRandomWordCommand.execute(Collections.singletonList("abc"));
        Assert.assertTrue(TooMuchWordResponse.failed());

        Response wrongSizeWordResponse = setRandomWordCommand.execute(Collections.singletonList("1"));
        Assert.assertTrue(wrongSizeWordResponse.failed());

        Response properSizeWordResponse = setRandomWordCommand.execute(Collections.singletonList("5"));
        Assert.assertFalse(properSizeWordResponse.failed());
    }

    @Test
    public void testHelpCommand() {
        Hangman hangman = new Hangman(System.out);
        HelpCommand helpCommand = new HelpCommand(hangman);

        Response emptyResponse = helpCommand.execute(Collections.emptyList());
        Assert.assertFalse(emptyResponse.failed());

        Response TooMuchWordResponse = helpCommand.execute(Collections.singletonList("abc"));
        Assert.assertFalse(TooMuchWordResponse.failed());

        Response wrongSizeWordResponse = helpCommand.execute(Collections.singletonList("1"));
        Assert.assertFalse(wrongSizeWordResponse.failed());

        Response properSizeWordResponse = helpCommand.execute(Collections.singletonList("5"));
        Assert.assertFalse(properSizeWordResponse.failed());

        List<String> tooMuchWords = Arrays.asList("abc", "def");
        Response tooMuchWordsResponse = helpCommand.execute(tooMuchWords);
        Assert.assertFalse(tooMuchWordsResponse.failed());
    }


}
