package de.elite.games.hangman;

import de.elite.games.cli.CommandList;
import de.elite.games.cli.CommandProvider;
import de.elite.games.cli.DefaultCommandList;
import de.elite.games.hangman.command.SetRandomWordCommand;
import de.elite.games.hangman.command.ShowCommand;
import de.elite.games.hangman.command.TryLetterCommand;
import de.elite.games.hangman.command.TrySolutionCommand;

class HangmanCommandProvider implements CommandProvider {

    private final DefaultCommandList mapping;

    HangmanCommandProvider(Hangman hangman) {
        mapping = new DefaultCommandList();
        mapping.add(new ShowCommand(hangman));
        mapping.add(new SetRandomWordCommand(hangman));
        mapping.add(new TryLetterCommand(hangman));
        mapping.add(new TrySolutionCommand(hangman));
    }

    @Override
    public CommandList getCommands() {
        return mapping;
    }
}
