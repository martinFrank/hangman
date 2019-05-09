package com.github.martinfrank.hangman.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.hangman.Hangman;
import com.github.martinfrank.hangman.WordReader;

import java.util.Collections;
import java.util.List;

public class SetRandomWordCommand extends Command<Hangman> {

    private static final String FILENAME = "./src/test/resources/words.txt";

    public SetRandomWordCommand(Hangman hangman) {
        super(hangman, "setup");
    }

    @Override
    public Response execute(List<String> parameter) {
        List<String> words = new WordReader(FILENAME).readAllWordsWithLength(8);
        Collections.shuffle(words);
        getApplication().setup(words.get(0).toUpperCase());
        return Response.success();
    }
}
