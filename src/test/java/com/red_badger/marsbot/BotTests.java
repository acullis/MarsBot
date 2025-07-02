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
}
