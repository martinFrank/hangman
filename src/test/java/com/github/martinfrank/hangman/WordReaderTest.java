package com.github.martinfrank.hangman;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class WordReaderTest {

    private static final String filename = "words.txt";

    @Test
    public void testProperWordLength() throws IOException {
        final int length = 8;
        File f = new File(filename);
        if (!f.exists()) {
            f.createNewFile();
        }
        List<String> words = new WordReader(filename).readAllWordsWithLength(length);
        Collections.shuffle(words);
        for (String word : words) {
            Assert.assertEquals(length, word.length());
        }
        if (f.exists()) {
            f.delete();
        }
    }

    @Test
    public void testExceptionHandling() {
        Assert.assertTrue(new WordReader("filename").readAllWordsWithLength(5).isEmpty());
    }
}
