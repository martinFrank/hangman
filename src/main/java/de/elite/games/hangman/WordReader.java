package de.elite.games.hangman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordReader.class);
    private final String filename;

    public WordReader(String filename) {
        this.filename = filename;
    }

    public List<String> readAllWordsWithLength(int length) {
        try (Stream<String> lines = Files.lines(Paths.get(filename), Charset.defaultCharset())) {
            return lines.filter(line -> line.length() == length).collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.debug("failed to load words... {}", e);
        }
        return Collections.emptyList();
    }
}
