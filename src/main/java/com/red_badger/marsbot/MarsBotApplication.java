package com.red_badger.marsbot;

import com.red_badger.marsbot.util.FileReaderUtil;
import com.red_badger.marsbot.util.StringUtil;
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
		//SpringApplication.run(MarsBotApplication.class, args);
		MarsBotApplication app= new MarsBotApplication(args);
	}

	public MarsBotApplication(String[] args) {
		//System.out.println("Mars Bot Application Running ...");
		if(args.length > 0) {
//			System.out.println("using:");
//			for (int i = 0; i < args.length; i++) {
//				System.out.println(args[i]);
//			}

			ArrayList<String> fileContent = null;
			try{
				fileContent = FileReaderUtil.ReadFile(args[0]);
				int fileContentSize = fileContent.size();
				if(fileContentSize > 1){

					//Resolve a given dimention string into X, y for simple map creation
					int[] mapSize = StringUtil.StringToIntArray(fileContent.get(0));
					// Create map base on first line dimensions
					Map map = createMap(mapSize[0], mapSize[1]);


					int botCount = 1;
					while(botCount+2 <= fileContentSize ){
						BotOrientation orientation = StringUtil.StringToBotOrientation(fileContent.get(botCount));
						MapBlock location = map.getBlock(orientation.getX(), orientation.getY());
						Bot bot = new Bot(location, orientation);
						bot.updateLocation(map, location);
						processBot(map, bot, fileContent.get(botCount+1));
						// Final Bot report
						System.out.println(bot.toString());
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

	public Map createMap(int x, int y) {
		Map map = new Map(x, y);
		//System.out.println("map="+ map.toString());
		return map;
	}

	private static void processBot(Map map, Bot bot, String commandString) {
		//System.out.println("Start map="+ map.toString());
		//System.out.println("bot="+ bot.toString());
		//System.out.println("commandString="+ commandString);
		for (int i = 0; i < commandString.length() && !bot.getOrientation().isLost(); i++) {
			processBot(map, bot, commandString.charAt(i));
		}
	}

	private static void processBot(Map map, Bot bot, char commandChar) {
		//System.out.println("commandString="+ commandChar);
		switch (commandChar){
			case 'F':
				//System.out.println("Move Forward");
				bot.moveForward(map);
				break;
			case 'L':
				//System.out.println("Turn Left");
				bot.turnLeft();
				break;
			case 'R':
				//System.out.println("Turn Right");
				bot.turnRight();
				break;
			default:
				System.out.println("processBot unknown command "+ commandChar);
		}
		//System.out.println("map="+ map.toString());
	}
}
