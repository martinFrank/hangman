package com.github.martinfrank.hangman;

class Word {

    @SuppressWarnings("squid:S1700") //this is the crucial Part of the 'Word class'
    private final String word;

    Word(String word) {
        this.word = word;
    }

    String show(Letters letters) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (letters.contains(Character.toString(word.charAt(i)))) {
                sb.append(word.charAt(i));
            } else {
                sb.append("_");
            }
        }
        return sb.toString();
    }

    boolean mismatches(String letter) {
        String l = letter.toUpperCase();
        return !word.contains(l);
    }

    String show() {
        return word;
    }

    boolean isSolved(Letters letters) {
        for (int i = 0; i < word.length(); i++) {
            if (!letters.contains(Character.toString(word.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
