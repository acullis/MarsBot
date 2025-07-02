package com.red_badger.marsbot.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReaderUtil {

    public static ArrayList<String> ReadFile(String fileName) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        return ReadFile(currentDirectory, fileName);
    }

    public static ArrayList<String> ReadFile(String filePath, String fileName) throws IOException {
        if(filePath == null ||  filePath.length()==0) {
            return null;
        }
        var fileContent = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath + File.separator + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            throw e;
        }
        return fileContent;
    }
}
