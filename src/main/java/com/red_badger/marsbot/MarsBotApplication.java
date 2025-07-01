package com.red_badger.marsbot;

import com.red_badger.marsbot.util.FileReaderUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
public class MarsBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsBotApplication.class, args);
		System.out.println("Mars Bot Application Running ...");
		if(args.length > 0) {
			System.out.println("using:");
			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
			}

			ArrayList<String> fileContent = null;
			try{
				fileContent = FileReaderUtil.ReadFile(args[0]);
				for (int i = 0; i < fileContent.size(); i++) {
					System.out.println("fileContent "+i+"->"+fileContent.get(i));
				}
			} catch (IOException e) {
				System.err.println("Error reading the file: " + e.getMessage());
			}
		}
	}

}
