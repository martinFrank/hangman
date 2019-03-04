package de.elite.games.hangman;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordReader {

    private final String filename;

    public WordReader(String filename) {
        this.filename = filename;
    }

    public List<String> readAllWordsWithLength(int length) {
        try (Stream<String> lines = Files.lines(Paths.get(filename), Charset.defaultCharset())) {
            return lines.filter(line -> line.length() == length).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
