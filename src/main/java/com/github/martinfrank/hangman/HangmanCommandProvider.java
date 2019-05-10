package com.github.martinfrank.hangman;

import com.github.martinfrank.cli.CommandList;
import com.github.martinfrank.cli.CommandProvider;
import com.github.martinfrank.cli.DefaultCommandList;
import com.github.martinfrank.hangman.command.*;

class HangmanCommandProvider implements CommandProvider {

    private final DefaultCommandList mapping;

    HangmanCommandProvider(Hangman hangman) {
        mapping = new DefaultCommandList();
        mapping.add(new ShowCommand(hangman));
        mapping.add(new SetWordCommand(hangman));
        mapping.add(new SetRandomWordCommand(hangman));
        mapping.add(new TryLetterCommand(hangman));
        mapping.add(new TrySolutionCommand(hangman));
    }

    @Override
    public CommandList getCommands() {
        return mapping;
    }
}
