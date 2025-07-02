package com.red_badger.marsbot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTests {

    @Test
    void basicBotTest() {
        int x = 2;
        int y = 2;

        Map sut = new Map(x, y);

        assertEquals(x+1, sut.getXLength());
        assertEquals(y+1, sut.getYLength());
        //System.out.println(sut.toString());
    }

    @Test
    void sampleMapTest() {
        int x = 5;
        int y = 3;

        Map sut = new Map(x, y);

        assertEquals(x+1, sut.getXLength());
        assertEquals(y+1, sut.getYLength());
        //System.out.println(sut.toString());
    }

    @Test
    void bigMapTest() {
        int x = 50;
        int y = 50;

        Map sut = new Map(x, y);

        assertEquals(x+1, sut.getXLength());
        assertEquals(y+1, sut.getYLength());
        //System.out.println(sut.toString());
    }
}
