package com.red_badger.marsbot;

import static com.red_badger.marsbot.BotOrientation.*;

public final class Bot {

    private MapBlock location;
    private BotOrientation orientation;

    public Bot(MapBlock location, BotOrientation orientation) {
        if(location!=null)
            this.location = location;

        if(orientation!=null)
            this.orientation = orientation;
    }

    public BotOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(BotOrientation orientation) {
        this.orientation = orientation;
    }

    public void turnLeft(){
        orientation.turnLeft();
    }

    public void turnRight(){
        orientation.turnRight();
    }

    public MapBlock getLocation() {
        return location;
    }

    public void setLocation(MapBlock mapBlock) {
        this.location = mapBlock;
    }

    public MapBlock moveForward(Map map) {
        MapBlock newLocation;
        int newX = orientation.getX();
        int newY = orientation.getY();
        switch (orientation.getDir()){
            case N:
                newY+=1; // Move North Y plus 1
                newLocation = map.getBlock(newX, newY);
                return updateLocation(map, newLocation);
            case E:
                newX+=1; // Move East X plus 1
                newLocation = map.getBlock(newX, newY);
                return updateLocation(map, newLocation);
            case S:
                newY-=1; // Move South Y minus 1
                newLocation = map.getBlock(newX, newY);
                return updateLocation(map, newLocation);
            case W:
                newX-=1; // Move West X minus 1
                newLocation = map.getBlock(newX, newY);
                return updateLocation(map, newLocation);
            default:
                System.out.println("moveForward unkown direction");
                return location;
        }
    }

    public MapBlock updateLocation(Map map, MapBlock newLocation) {
        MapBlock currentLocation = map.getBlock(orientation.getX(), orientation.getY());
        if((currentLocation != null && currentLocation.hasScent()) && newLocation==null) {
            return currentLocation;
        } else {
            if(newLocation==null){
                MapBlock lostBotBlock = map.getBlock(orientation.getX(), orientation.getY());
                orientation.setLost();
                if (lostBotBlock != null) {
                    lostBotBlock.setScent();
                    lostBotBlock.clearBot();
                }
                return newLocation;
            } else {
                if (currentLocation != null) {
                    currentLocation.clearBot();
                }
                orientation.setX(newLocation.getX());
                orientation.setY(newLocation.getY());
                newLocation.setBot(this);
                return newLocation;
            }
        }
    }

    @Override
    public String toString() {
        return orientation.toString();
    }
}
