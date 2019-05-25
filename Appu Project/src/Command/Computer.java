package Command;

import MainFrame.InputPanel;
import MainFrame.MainFrame;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Computer {
    private static final JSONParser parser = new JSONParser();
    
    
    private static String getCommand(String command) { 
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/Database/ControlPC.json"));
            for (Object obj : jsonArray) {                 
                JSONObject jsonObject = (JSONObject) obj;               
                String key = "";
                if ("english".equals(MainFrame.getLanguage()))
                    key = (String) jsonObject.get("Eng");
                else
                    key = (String) jsonObject.get("Viet");
                if(command.contains(key)) {
                    return (String) jsonObject.get("Command");
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {}
        return null;
    }
    
    public static void controlComputer() {
        String command = InputPanel.inputField.getText();
        Runtime runtime = Runtime.getRuntime();
        Process proc = null;
        
        String control = getCommand(command);
        if (control != null) {
            try {
                proc = runtime.exec(control);
            } catch (IOException ex) {}
            Performance.online = false;
        }
    }
}
