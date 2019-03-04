package de.elite.games.hangman.command;

import de.elite.games.cli.Command;
import de.elite.games.cli.Response;
import de.elite.games.hangman.Hangman;
import de.elite.games.hangman.WordReader;

import java.util.Collections;
import java.util.List;

public class SetRandomWordCommand extends Command<Hangman> {

    public SetRandomWordCommand(Hangman hangman) {
        super(hangman, "setup");
    }

    @Override
    public Response execute(List<String> parameter) {
        List<String> words = new WordReader("src/main/resources/words.txt").readAllWordsWithLength(8);
        Collections.shuffle(words);
        getApplication().setup(words.get(0).toUpperCase());
        return Response.success();
    }
}
