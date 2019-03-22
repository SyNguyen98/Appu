/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.ArrayList;
import java.util.List;

public class Proccess {
    public static int width;
    public static int height;
    private static final int maxChar = 20;
    
    public static String MakeNewLine(String commandString) {
        List<String> listStr = new ArrayList<>();  
        if(commandString.length() > maxChar) {
            int i, j = 0;
            for (i = maxChar; i < commandString.length(); i += maxChar) {
                if(commandString.charAt(i) == ' ') {
                    String str = commandString.substring(j, i++);
                    j = i;
                    listStr.add(str);
                } else if (commandString.charAt(i+1) == ' ') {
                    String str = commandString.substring(j, ++i);
                    j = i++;
                    listStr.add(str);
                } else {
                    while (commandString.charAt(i-1) != ' ') i--;
                    String str = commandString.substring(j, --i);
                    j = i++;
                    listStr.add(str);
                }
            }
                String str = commandString.substring(j);
                listStr.add(str);
                width = maxChar * 8;    
        }
        else {
            listStr.add(commandString);  
            width = commandString.length() * 8;   
        }
        height = listStr.size() * 25;
        commandString = "";
        for (String str : listStr)
            commandString += str + "@";         // @ is the mark for new line
        return commandString;
    }
}
