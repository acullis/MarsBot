package com.red_badger.marsbot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BotTests {

    @Test
    void basicBotTest() {
        int x = 1;
        int y = 1;
        char dir = 'N';

        BotOrientation orientation = new BotOrientation(x, y, dir);

        Bot sut = new Bot(null, orientation);
        assertEquals("1 1 N", sut.toString());
    }


    @Test
    void moveForwardNorthTest() {
        Map map = new Map(2, 2);
        int x = 1;
        int y = 1;
        char dir = 'N';

        MapBlock startBlock = map.getBlock(x, y);
        BotOrientation orientation = new BotOrientation(x, y, dir);

        Bot sut1 = new Bot(startBlock, orientation);
        assertEquals("1 1 N", sut1.toString());
        sut1.moveForward(map);
        assertEquals("1 2 N", sut1.toString());
        sut1.moveForward(map);
        assertEquals("1 2 N LOST", sut1.toString());

        BotOrientation orientation2 = new BotOrientation(x, y, dir);
        Bot sut2 = new Bot(startBlock, orientation2);
        assertEquals("1 1 N", sut2.toString());
        sut2.moveForward(map);
        assertEquals("1 2 N", sut2.toString());
        sut2.moveForward(map);
        assertEquals("1 2 N", sut2.toString());
    }


    @Test
    void moveForwardEastTest() {
        Map map = new Map(2, 2);
        int x = 1;
        int y = 1;
        char dir = 'E';

        MapBlock startBlock = map.getBlock(x, y);
        BotOrientation orientation = new BotOrientation(x, y, dir);

        Bot sut1 = new Bot(startBlock, orientation);
        assertEquals("1 1 E", sut1.toString());
        sut1.moveForward(map);
        assertEquals("2 1 E", sut1.toString());
        sut1.moveForward(map);
        assertEquals("2 1 E LOST", sut1.toString());

        BotOrientation orientation2 = new BotOrientation(x, y, dir);
        Bot sut2 = new Bot(startBlock, orientation2);
        assertEquals("1 1 E", sut2.toString());
        sut2.moveForward(map);
        assertEquals("2 1 E", sut2.toString());
        sut2.moveForward(map);
        assertEquals("2 1 E", sut2.toString());
    }


    @Test
    void moveForwardSouthTest() {
        Map map = new Map(2, 2);
        int x = 1;
        int y = 1;
        char dir = 'S';

        MapBlock startBlock = map.getBlock(x, y);
        BotOrientation orientation = new BotOrientation(x, y, dir);

        Bot sut1 = new Bot(startBlock, orientation);
        assertEquals("1 1 S", sut1.toString());
        sut1.moveForward(map);
        assertEquals("1 0 S", sut1.toString());
        sut1.moveForward(map);
        assertEquals("1 0 S LOST", sut1.toString());

        BotOrientation orientation2 = new BotOrientation(x, y, dir);
        Bot sut2 = new Bot(startBlock, orientation2);
        assertEquals("1 1 S", sut2.toString());
        sut2.moveForward(map);
        assertEquals("1 0 S", sut2.toString());
        sut2.moveForward(map);
        assertEquals("1 0 S", sut2.toString());
    }


    @Test
    void moveForwardWestTest() {
        Map map = new Map(2, 2);
        int x = 1;
        int y = 1;
        char dir = 'W';

        MapBlock startBlock = map.getBlock(x, y);
        BotOrientation orientation = new BotOrientation(x, y, dir);

        Bot sut1 = new Bot(startBlock, orientation);
        assertEquals("1 1 W", sut1.toString());
        sut1.moveForward(map);
        assertEquals("0 1 W", sut1.toString());
        sut1.moveForward(map);
        assertEquals("0 1 W LOST", sut1.toString());

        BotOrientation orientation2 = new BotOrientation(x, y, dir);
        Bot sut2 = new Bot(startBlock, orientation2);
        assertEquals("1 1 W", sut2.toString());
        sut2.moveForward(map);
        assertEquals("0 1 W", sut2.toString());
        sut2.moveForward(map);
        assertEquals("0 1 W", sut2.toString());
    }
}
