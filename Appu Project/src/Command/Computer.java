package Command;

import MainFrame.InputPanel;
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
    private static final Desktop desktop = Desktop.getDesktop();
    private static final JSONParser parser = new JSONParser();
    
    
    private static String getCommand(String command) { 
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/Database/ControlPC.json"));
            for (Object obj : jsonArray) {                 
                JSONObject jsonObject = (JSONObject) obj;               
                String key = (String) jsonObject.get("Key");
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
            System.exit(0);
            Performance.online = false;
        }
        if(command.contains("open word")) {
            try {
                desktop.open(new File("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\WINWORD.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            Performance.online = false;
        }
        if(command.contains("open pc info")) {
            try {
                desktop.open(new File("C:\\Windows\\System32\\dxdiag.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            Performance.online = false;
        }
        if(command.contains("open powerpoint")) {
            try {
                desktop.open(new File("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\POWERPNT.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            Performance.online = false;
        }
        if(command.contains("open excel")) {
            try {
                desktop.open(new File("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            Performance.online = false;
        }
        if(command.contains("open draw")) {
            try {
                desktop.open(new File("C:\\Windows\\System32\\mspaint.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            Performance.online = false;
        }
        if(command.contains("open control")) {
            try {
                desktop.open(new File("C:\\Windows\\System32\\control.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            Performance.online = false;
        }
        if(command.contains("open calculator")) {
            try {
                desktop.open(new File("C:\\Windows\\System32\\calc.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            Performance.online = false;
        }
        if(command.contains("data structure")) {
            try {
                desktop.open(new File("src/Database/visualization.jar"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            Performance.online = false;
        }
    }
}
