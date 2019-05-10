package com.github.martinfrank.hangman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordReader.class);
    private final String filename;

    public WordReader(String filename) {
        this.filename = filename;
    }

    public List<String> readAllWordsWithLength(int length) {
        BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filename)));
        String line = "";
        List<String> words = new ArrayList<>();
        try {
            do {
                line = br.readLine();
                if (line != null && line.length() == length) {
                    words.add(line);
                }
            } while (line != null);
        } catch (IOException e) {
            LOGGER.debug("failed to load words... {}", e);
            Arrays.asList("ERROR");
        }
        return words;
    }
}
