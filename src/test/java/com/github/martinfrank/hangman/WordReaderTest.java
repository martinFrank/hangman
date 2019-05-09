package com.github.martinfrank.hangman;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class WordReaderTest {

    @Test
    public void testProperWordLength() throws IOException {
        final int length = 8;

        File f = File.createTempFile("pre", "suf");
        String fileName = f.getAbsolutePath() + File.pathSeparator + f.getName();
        System.out.println("filename: " + f + " exists?=" + f.exists());
        List<String> words = new WordReader(fileName).readAllWordsWithLength(length);
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
