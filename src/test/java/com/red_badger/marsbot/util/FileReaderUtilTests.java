package com.red_badger.marsbot.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderUtilTests {

    @Test
    void nullFileTest() {
        ArrayList<String> fileContent = null;
        try{
            fileContent = FileReaderUtil.ReadFile(null);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        assertNull(fileContent);
    }


    @Test
    void expectedFileTest() {
        ArrayList<String> fileContent = null;
        try{
            fileContent = FileReaderUtil.ReadFile("Input.txt");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        assertEquals(7, fileContent.size());
    }
}
