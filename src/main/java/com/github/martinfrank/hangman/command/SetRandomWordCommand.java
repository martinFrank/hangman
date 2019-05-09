package com.github.martinfrank.hangman.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.hangman.Hangman;
import com.github.martinfrank.hangman.WordReader;

import java.util.Collections;
import java.util.List;

public class SetRandomWordCommand extends Command<Hangman> {

    private static final String FILENAME = "./src/main/resources/words.txt";

    public SetRandomWordCommand(Hangman hangman) {
        super(hangman, "setup");
    }

    @Override
    public Response execute(List<String> parameters) {
        String word = null;
        if (parameters.isEmpty()) {
            List<String> words = new WordReader(FILENAME).readAllWordsWithLength(8);
            if (words.isEmpty()) {
                return Response.fail("could not read default input file " + FILENAME);
            }
            Collections.shuffle(words);
            word = words.get(0).toUpperCase();
        }
        if (parameters.size() == 1) {
            word = parameters.get(0).toUpperCase();
        }
        if (parameters.size() > 1) {
            return Response.fail("too much words for hangman - only ONE word is allowed");
        }
        getApplication().setup(word);
        return Response.success();
    }
}
