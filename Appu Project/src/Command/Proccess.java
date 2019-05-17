package Command;

import java.util.ArrayList;
import java.util.List;

public class Proccess {
    public static int width, height;
    private static final int maxChar = 23;
    
    public static String makeNewLine(String commandString) {
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
                width = maxChar * 7;    
        }
        else {
            listStr.add(commandString);  
            width = commandString.length() * 7;   
        }
        height = listStr.size() * 23;
        commandString = "";
        for (String str : listStr)
            commandString += str + "@";         // @ is the mark for new line
        return commandString;
    }
}
