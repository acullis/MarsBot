package com.red_badger.marsbot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BotOrientationTests {

    @Test
    void basicBotOrientationTest() {
        int x = 1;
        int y = 1;
        char dir = 'N';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("1 1 N", sut.toString());
    }

    @Test
    void isLostTest() {
        int x = 1;
        int y = 1;
        char dir = 'N';

        BotOrientation sut = new BotOrientation(x, y, dir);
        sut.setLost();
        assertEquals("1 1 N LOST", sut.toString());
    }

    @Test
    void negativeXTest() {
        int x = -1;
        int y = 1;
        char dir = 'N';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("-1 1 N", sut.toString());
        assertEquals(false, sut.isValid());
    }

    @Test
    void invalidXTest() {
        int x = 51;
        int y = 1;
        char dir = 'N';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("51 1 N", sut.toString());
        assertEquals(false, sut.isValid());
    }

    @Test
    void negativeYTest() {
        int x = 1;
        int y = -1;
        char dir = 'N';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("1 -1 N", sut.toString());
        assertEquals(false, sut.isValid());
    }

    @Test
    void InvalidDirTest() {
        int x = 1;
        int y = 1;
        char dir = 'U';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("1 1 U", sut.toString());
        assertEquals(false, sut.isValid());
    }

    // turnLeft Test
    @Test
    void NorthTurnLeftTest() {
        int x = 1;
        int y = 1;
        char dir = 'N';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("1 1 N", sut.toString());
        assertEquals('W', sut.turnLeft());
    }

    @Test
    void WestTurnLeftTest() {
        int x = 1;
        int y = 1;
        char dir = 'W';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("1 1 W", sut.toString());
        assertEquals('S', sut.turnLeft());
    }

    @Test
    void SouthTurnLeftTest() {
        int x = 1;
        int y = 1;
        char dir = 'S';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("1 1 S", sut.toString());
        assertEquals('E', sut.turnLeft());
    }

    @Test
    void EastTurnLeftTest() {
        int x = 1;
        int y = 1;
        char dir = 'E';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("1 1 E", sut.toString());
        assertEquals('N', sut.turnLeft());
    }

    // turnRight Test
    @Test
    void NorthTurnRightTest() {
        int x = 1;
        int y = 1;
        char dir = 'N';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("1 1 N", sut.toString());
        assertEquals('E', sut.turnRight());
    }

    @Test
    void EastTurnRightTest() {
        int x = 1;
        int y = 1;
        char dir = 'E';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("1 1 E", sut.toString());
        assertEquals('S', sut.turnRight());
    }

    @Test
    void SouthTurnRightTest() {
        int x = 1;
        int y = 1;
        char dir = 'S';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("1 1 S", sut.toString());
        assertEquals('W', sut.turnRight());
    }

    @Test
    void WestTurnRightTest() {
        int x = 1;
        int y = 1;
        char dir = 'W';

        BotOrientation sut = new BotOrientation(x, y, dir);
        assertEquals("1 1 W", sut.toString());
        assertEquals('N', sut.turnRight());
    }
}
