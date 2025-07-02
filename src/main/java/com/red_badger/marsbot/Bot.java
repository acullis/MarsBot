package com.red_badger.marsbot;

import java.util.Arrays;

public class Bot {

    protected int x;
    protected int y;
    protected String direction;
    protected boolean lost = false;
    protected MapBlock mapBlock;

    public Bot(String locationString) {
        if(locationString != null && locationString.length()>0 && locationString.contains(" ")){
            String[] botLocation = locationString.split(" "); // Splits by space
            //System.out.println("BOT "+ Arrays.toString(botLocation));
            if( botLocation.length > 2 ){
                x = Integer.parseInt(botLocation[0]);
                y = Integer.parseInt(botLocation[1]);
                direction = botLocation[2];
                System.out.println(this);
            }
        }
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost() {
        lost = true;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public MapBlock getMapBlock() {
        return mapBlock;
    }

    public void setMapBlock(MapBlock mapBlock) {
        this.mapBlock = mapBlock;
    }

    @Override
    public String toString() {
        if(lost)
            return  x + " " + y + " " + direction + " LOST";
        else
            return  x + " " + y + " " + direction;
    }
}
