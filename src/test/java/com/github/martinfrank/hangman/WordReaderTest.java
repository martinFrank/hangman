package com.github.martinfrank.hangman;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class WordReaderTest {

    @Test
    public void testProperWordLength() throws IOException {
        String wordA = "abcde";
        String wordF = "fffff";
        final int length = wordA.length();

        File f = File.createTempFile("pre", "suf");
        f.createNewFile();
        BufferedWriter br = new BufferedWriter(new FileWriter(f));
        br.write(wordA);
        br.write(wordF);
        br.close();
        String fileName = f.getAbsolutePath();
        System.out.println("filename: " + f + " exists?=" + f.exists());
        List<String> words = new WordReader(fileName).readAllWordsWithLength(length);
        Collections.shuffle(words);
        for (String word : words) {
            Assert.assertEquals(length, word.length());
            Assert.assertTrue(words.contains(wordA));
            Assert.assertTrue(words.contains(wordF));
        }
        f.deleteOnExit();
    }

    @Test
    public void testExceptionHandling() {
        Assert.assertTrue(new WordReader("filename").readAllWordsWithLength(5).isEmpty());
    }
}
