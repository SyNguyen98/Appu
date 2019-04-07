package Command;

import OtherFrame.BrowserFrame;
import MainFrame.InputPanel;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Commands {
    private static final Desktop desktop = Desktop.getDesktop();
    private static final JSONParser parser = new JSONParser();
    public static boolean online;
    
    private static String readDatabase(String command) { 
        String name = "";
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/Database/Website.json"));
            for (Object obj : jsonArray) {                 
                JSONObject jsonObject = (JSONObject) obj;               
                String key = (String) jsonObject.get("Key");
                int KeyIndex = command.indexOf(key);
                if(KeyIndex != -1) {
                    KeyIndex += key.length();
                    name = command.substring(++KeyIndex);
                    String link = (String) jsonObject.get("WebHead") + name + (String) jsonObject.get("WebTail");
                    return link;
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {}
        return null;
    }
    
    public static void accessInternet() {   
        String command = InputPanel.inputField.getText();
        command = command.replace(" ", "+");

        String url = readDatabase(command);
        if (url != null)
            try {
                desktop.browse(new URI(url));
            } catch (URISyntaxException | IOException e) {}
        else {
            BrowserFrame browser = new BrowserFrame("https://www.google.com/search?q=" + command);
            browser.setVisible(true);
            browser.setTitle("Google");
        }         
    }
    
    public static void controlComputer() {
        String command = InputPanel.inputField.getText();
        Runtime runtime = Runtime.getRuntime();
        Process proc = null;
        if(command.contains("shut down")) {
            try {
                proc = runtime.exec("shutdown -s -t 0");
            } catch (IOException ex) {}
            System.exit(0);
            online = false;
        }
        if(command.contains("go to sleep")) {            
            try {
                proc = runtime.exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
            } catch (IOException ex) {}
            System.exit(0);
            online = false;
        }
        if(command.contains("open word")) {
            try {
                desktop.open(new File("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\WINWORD.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            online = false;
        }
        if(command.contains("open powerpoint")) {
            try {
                desktop.open(new File("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\POWERPNT.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            online = false;
        }
        if(command.contains("open excel")) {
            try {
                desktop.open(new File("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            online = false;
        }
    }
}