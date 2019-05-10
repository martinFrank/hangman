package com.github.martinfrank.hangman;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class WordReaderTest {

    @Test
    public void testProperWordLength() throws IOException {
        int length = 5;
        List<String> words = new WordReader("./words.txt").readAllWordsWithLength(length);
        Collections.shuffle(words);
        Assert.assertFalse(words.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testExceptionHandling() {
        new WordReader("filename").readAllWordsWithLength(5).isEmpty();
    }
}
