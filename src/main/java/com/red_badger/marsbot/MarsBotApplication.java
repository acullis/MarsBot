package com.red_badger.marsbot;

import com.red_badger.marsbot.util.FileReaderUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
				int fileContentSize = fileContent.size();
				if(fileContentSize > 1){

					Map map = new Map(fileContent.get(0));
					//System.out.println("map="+ map.toString());

					int botCount = 1;
					while( botCount+2 <= fileContentSize ){
						Bot bot = new Bot(fileContent.get(botCount));
						processBot(map, bot, fileContent.get(botCount+1));
						botCount+=2;
					}
				}

			} catch (IOException e) {
				System.err.println("Error reading the file: " + e.getMessage());
			}
		} else {
			System.out.println("No Input file found - use: java -jar .\\marsbot.jar Input.txt");
		}
	}



	private static void processBot(Map map, Bot bot, String commandString) {
		MapBlock mapBlock = map.getBlock(bot.x, bot.y);
		mapBlock.setBot(bot);
		System.out.println("map="+ map.toString());
	}
}
