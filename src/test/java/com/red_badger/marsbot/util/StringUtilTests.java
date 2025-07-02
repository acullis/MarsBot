package com.red_badger.marsbot.util;

import com.red_badger.marsbot.BotOrientation;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StringUtilTests {


    @Test
    void basicStringToStringArrayTest() {
        String location = "1 1";
        String [] expected = {"1","1"};
        assertEquals(Arrays.toString(expected), Arrays.toString(StringUtil.StringToStringArray(location)));
    }

    @Test
    void basicStringToIntArrayTest() {
        String location = "1 1";
        int [] expected = {1,1};
        assertEquals(Arrays.toString(expected), Arrays.toString(StringUtil.StringToIntArray(location)));
    }

    @Test
    void basicStringToBotOrientationTest() {
        String location = "1 1 N";
        BotOrientation expected = new BotOrientation(1, 1, BotOrientation.N);
        assertEquals(expected.toString(), StringUtil.StringToBotOrientation(location).toString());
    }

    @Test
    void negativeXStringToBotOrientationTest() {
        String location = "-1 1 N";
        assertNull(StringUtil.StringToBotOrientation(location));
    }

    @Test
    void InvalidXStringToBotOrientationTest() {
        String location = "51 1 N";
        assertNull(StringUtil.StringToBotOrientation(location));
    }

    @Test
    void negativeYStringToBotOrientationTest() {
        String location = "1 -1 N";
        assertNull(StringUtil.StringToBotOrientation(location));
    }

    @Test
    void InvalidYStringToBotOrientationTest() {
        String location = "1 51 N";
        assertNull(StringUtil.StringToBotOrientation(location));
    }

    @Test
    void InvalidDirectionStringToBotOrientationTest() {
        String location = "1 1 U";
        assertNull(StringUtil.StringToBotOrientation(location));
    }
}
