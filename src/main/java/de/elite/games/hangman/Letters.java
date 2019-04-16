package de.elite.games.hangman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Letters {

    @SuppressWarnings("squid:S1700") //this is the crucial Part of the 'Letters class'
    private final List<String> letters = new ArrayList<>();

    Letters() {

    }

    Letters(String word) {
        for (int i = 0; i < word.length(); i++) {
            String str = "" + word.charAt(i);
            add(str);
        }
    }

    void reset() {
        letters.clear();
    }

    void add(String letter) {
        String l = letter.toUpperCase();
        if (!letters.contains(l)) {
            letters.add(letter.toUpperCase());
        }
    }

    boolean contains(String letter) {
        String l = letter.toUpperCase();
        return letters.contains(l);
    }

    String show() {
        Collections.sort(letters);
        return letters.toString();
    }

    void addAll(Letters tryLetters) {
        for (String str : tryLetters.letters) {
            add(str);
        }
    }
}
