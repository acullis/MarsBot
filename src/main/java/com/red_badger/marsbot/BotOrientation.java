package com.red_badger.marsbot;

public class BotOrientation {
    public static final char N = 'N';
    public static final char E = 'E';
    public static final char S = 'S';
    public static final char W = 'W';

    private int x;
    private int y;
    private char dir;
    private boolean lost = false;

    public BotOrientation(int x, int y, char dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
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

    public char getDir() {
        return dir;
    }

    public void setDir(char dir) {
        this.dir = dir;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost() {
        this.lost = true;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public char turnLeft(){
        switch (dir){
            case N:
                dir = W;
                break;
            case E:
                dir = N;
                break;
            case S:
                dir = E;
                break;
            case W:
                dir = S;
                break;
            default:
                break;
        }
        return dir;
    }

    public char turnRight(){
        switch (dir){
            case N:
                dir = E;
                break;
            case E:
                dir = S;
                break;
            case S:
                dir = W;
                break;
            case W:
                dir = N;
                break;
            default:
                break;
        }
        return dir;
    }

    public boolean isValid() {
        boolean validX = x >=0 && x <= 50;
        boolean validY = y >=0 && y <= 50;
        boolean validDIR = dir == N || dir == E || dir == S || dir == W;
        return validX && validY && validDIR;
    }

    @Override
    public String toString() {
        if(lost)
            return  x + " " + y + " " + dir + " LOST";
        else
            return  x + " " + y + " " + dir;
    }
}
