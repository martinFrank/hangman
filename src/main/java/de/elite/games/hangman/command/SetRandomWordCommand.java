package de.elite.games.hangman.command;

import de.elite.games.cli.Command;
import de.elite.games.cli.Response;
import de.elite.games.hangman.Hangman;
import de.elite.games.hangman.WordReader;

import java.util.Collections;
import java.util.List;

public class SetRandomWordCommand extends Command<Hangman> {

    private static final String filename = "./src/test/resources/words.txt";

    public SetRandomWordCommand(Hangman hangman) {
        super(hangman, "setup");
    }

    @Override
    public Response execute(List<String> parameter) {
        List<String> words = new WordReader(filename).readAllWordsWithLength(8);
        Collections.shuffle(words);
        getApplication().setup(words.get(0).toUpperCase());
        return Response.success();
    }
}
