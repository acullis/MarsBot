package com.red_badger.marsbot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapBlockTests {

    @Test
    void basicMapBlockTest() {
        int x = 1;
        int y = 1;

        MapBlock sut = new MapBlock(x, y);
        assertEquals(".", sut.toString());
    }

    @Test
    void getXTest() {
        int x = 2;
        int y = 3;

        MapBlock sut = new MapBlock(x, y);
        assertEquals(2, sut.getX());
    }

    @Test
    void setXTest() {
        int x = 1;
        int y = 1;

        MapBlock sut = new MapBlock(x, y);
        sut.setX(2);
        assertEquals(2, sut.getX());
    }

    @Test
    void setYTest() {
        int x = 1;
        int y = 1;

        MapBlock sut = new MapBlock(x, y);
        sut.setY(3);
        assertEquals(3, sut.getY());
    }

    @Test
    void getYTest() {
        int x = 2;
        int y = 3;

        MapBlock sut = new MapBlock(x, y);
        assertEquals(3, sut.getY());
    }

    @Test
    void hasScentTest() {
        int x = 1;
        int y = 1;

        MapBlock sut = new MapBlock(x, y);
        assertEquals(false, sut.hasScent());
        sut.setScent();
        assertEquals(true, sut.hasScent());
    }

    @Test
    void hasBotTest() {
        int x = 1;
        int y = 1;
        BotOrientation orientation = new BotOrientation(1, 1, BotOrientation.N);
        Bot bot = new Bot(null, orientation);

        MapBlock sut = new MapBlock(x, y);
        assertEquals(null, sut.getBot());
        sut.setBot(bot);
        assertEquals(bot, sut.getBot());
        assertEquals("A", sut.toString());
        sut.clearBot();
        assertEquals(null, sut.getBot());
        assertEquals(".", sut.toString());
    }

    @Test
    void NorthBotTest() {
        int x = 1;
        int y = 1;
        BotOrientation orientation = new BotOrientation(1, 1, BotOrientation.N);
        Bot bot = new Bot(null, orientation);

        MapBlock sut = new MapBlock(x, y);
        sut.setBot(bot);
        assertEquals("A", sut.toString());
    }

    @Test
    void EastBotTest() {
        int x = 1;
        int y = 1;
        BotOrientation orientation = new BotOrientation(1, 1, BotOrientation.E);
        Bot bot = new Bot(null, orientation);

        MapBlock sut = new MapBlock(x, y);
        sut.setBot(bot);
        assertEquals(">", sut.toString());
    }

    @Test
    void SouthBotTest() {
        int x = 1;
        int y = 1;
        BotOrientation orientation = new BotOrientation(1, 1, BotOrientation.S);
        Bot bot = new Bot(null, orientation);

        MapBlock sut = new MapBlock(x, y);
        sut.setBot(bot);
        assertEquals("V", sut.toString());
    }

    @Test
    void WestBotTest() {
        int x = 1;
        int y = 1;
        BotOrientation orientation = new BotOrientation(1, 1, BotOrientation.W);
        Bot bot = new Bot(null, orientation);

        MapBlock sut = new MapBlock(x, y);
        sut.setBot(bot);
        assertEquals("<", sut.toString());
    }

    @Test
    void ScentTest() {
        int x = 1;
        int y = 1;

        MapBlock sut = new MapBlock(x, y);
        sut.setScent();
        assertEquals("X", sut.toString());
    }

    @Test
    void UpBotTest() {
        int x = 1;
        int y = 1;
        BotOrientation orientation = new BotOrientation(1, 1, 'U');
        Bot bot = new Bot(null, orientation);

        MapBlock sut = new MapBlock(x, y);
        sut.setBot(bot);
        assertEquals("?", sut.toString());
    }
}
