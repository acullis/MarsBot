package com.red_badger.marsbot;

import static com.red_badger.marsbot.BotOrientation.*;

public final class MapBlock {

    private int x;
    private int y;
    private boolean scent = false;
    private Bot bot;

    public MapBlock(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean hasScent() {
        return scent;
    }

    public void setScent() {
        this.scent = true;
    }

    public void setScent(boolean scent) {
        this.scent = scent;
    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public void clearBot() {
        this.bot = null;
    }

    @Override
    public String toString() {
        if(this.bot != null) {
            return switch (this.bot.getOrientation().getDir()) {
                case N -> "A";
                case E -> ">";
                case S -> "V";
                case W -> "<";
                default -> "?";
            };
        } else if(this.scent) {
            return "X";
        }
        else {
            return ".";
        }
    }
}
