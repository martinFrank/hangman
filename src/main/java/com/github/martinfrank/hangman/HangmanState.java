package com.github.martinfrank.hangman;

import java.io.PrintStream;

class HangmanState {

    private State state;

    HangmanState() {
        state = State.START;
    }

    void nextState() {
        state = getNextState();
    }

    private State getNextState() {
        switch (state) {
            case START:
                return State.ONE;
            case ONE:
                return State.TWO;
            case TWO:
                return State.THREE;
            case THREE:
                return State.FOUR;
            case FOUR:
                return State.FIVE;
            case FIVE:
                return State.SIX;
            case SIX:
                return State.SEVEN;
            case SEVEN:
                return State.EIGHT;
            case EIGHT:
                return State.NINE;
            case NINE:
                return State.DEAD;
            default:
                return State.DEAD;
        }
    }

    @SuppressWarnings({"squid:S3776", "squid:S1192"})
        //honestly i tried to find a solution here, even on https://codereview.stackexchange.com/ but i didn't find anything
    void show(PrintStream out) {
        out.println("    " + (p(State.TWO) ? "________" : ""));
        out.println("    " + (p(State.FOUR) ? "|" : " ") + "      " + (p(State.THREE) ? "\\" : " ") + (p(State.ONE) ? "|" : " "));
        out.println("    " + (p(State.FIVE) ? "o" : " ") + "       " + (p(State.ONE) ? "|" : " "));
        out.println("   " + (p(State.SEVEN) ? "/" : " ") + (p(State.SIX) ? "|" : " ") + (p(State.EIGHT) ? "\\" : " ") + "      " + (p(State.ONE) ? "|" : " "));
        out.println("    " + (p(State.SIX) ? "|" : " ") + "       " + (p(State.ONE) ? "|" : " "));
        out.println("   " + (p(State.NINE) ? "/" : " ") + " " + (p(State.DEAD) ? "\\" : " ") + "      " + (p(State.ONE) ? "|" : " "));
        out.println(" ___________" + (p(State.ONE) ? "|" : "_") + "____");
        out.println(" |    " + s() + "/10     |");
        out.println(" |    " + (p(State.DEAD) ? "R.I.P" : "     ") + "     |");
    }

    private boolean p(State dest) {
        return state.passed(dest);
    }

    private String s() {
        if (state == State.DEAD) {
            return "" + state.s;
        } else {
            return " " + state.s;
        }
    }

    public boolean isDead() {
        return state == State.DEAD;
    }

    private enum State {
        START(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), DEAD(10);

        private final int s;

        State(int s) {
            this.s = s;
        }

        public boolean passed(State state) {
            return state.s <= s;
        }

    }

}
