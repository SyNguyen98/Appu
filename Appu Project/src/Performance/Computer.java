package Performance;

import MainFrame.InputPanel;
import MainFrame.MainFrame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Computer {
    private static final JSONParser parser = new JSONParser();  
    
    private static String getCommand(String command) { 
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new InputStreamReader(Computer.class.getResourceAsStream("/Database/ControlPC.json")));
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
        String command = InputPanel.inputField.getText().toLowerCase();   
        String control = getCommand(command);
        if (control != null) {
            try {
                Runtime runtime = Runtime.getRuntime();    
                Process proc = runtime.exec(control);
            } catch (IOException ex) {}
            Performance.online = false;
        }
    }
}
