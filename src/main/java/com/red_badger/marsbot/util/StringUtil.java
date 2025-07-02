package com.red_badger.marsbot.util;

import com.red_badger.marsbot.BotOrientation;

public class StringUtil {

    /*
        String to String Array - split on 'space' character
     */
    public static String[] StringToStringArray(String content) {
        if(content != null && content.length()>0 && content.contains(" ")){
            return content.split(" "); // Splits by space
        }
        return null;
    }

    /*
        String to int Array - split on 'space' character
        sample: "5 3" -> {5,3}
     */
    public static int[] StringToIntArray(String content) {
        if(content != null && content.length()>0 && content.contains(" ")){
            String[] contentStringArray = content.split(" "); // Splits by space
            int[] result = new int[contentStringArray.length];
            for (int i = 0; i < contentStringArray.length; i++) {
                result[i] = Integer.parseInt(contentStringArray[i]);
            }
            return result;
        }
        return null;
    }

    /*
        String to BotOrientation object - split on 'space' character
     */
    public static BotOrientation StringToBotOrientation(String content) {
        if(content != null && content.length()>0 && content.contains(" ")){
            String[] contentStringArray = content.split(" "); // Splits by space
            BotOrientation botOrientation = new BotOrientation(
                    Integer.parseInt(contentStringArray[0]),
                    Integer.parseInt(contentStringArray[1]),
                    contentStringArray[2].charAt(0));
            if(botOrientation.isValid()) {
                return botOrientation;
            }
        }
        return null;
    }
}
