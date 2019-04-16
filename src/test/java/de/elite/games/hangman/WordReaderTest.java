package de.elite.games.hangman;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class WordReaderTest {

    private static final String filename = "./src/test/resources/words.txt";

    @Test
    public void testProperWordLength() {
        final int length = 8;
        List<String> words = new WordReader(filename).readAllWordsWithLength(length);
        Collections.shuffle(words);
        for (String word : words) {
            Assert.assertEquals(length, word.length());
        }
    }

    @Test
    public void testExceptionHandling() {
        Assert.assertTrue(new WordReader("filename").readAllWordsWithLength(5).isEmpty());
    }
}
