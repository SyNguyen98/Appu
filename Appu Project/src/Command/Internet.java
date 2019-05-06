package Command;

import OtherFrame.BrowserFrame;
import MainFrame.InputPanel;
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Internet {
    private static final Desktop desktop = Desktop.getDesktop();
    private static final JSONParser parser = new JSONParser();
    
    private static String getLink(String command) { 
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/Database/Website.json"));
            for (Object obj : jsonArray) {                 
                JSONObject jsonObject = (JSONObject) obj;               
                String key = (String) jsonObject.get("Key");
                if (command.contains(key)) {
                    String name = command.replace(key + " ", "");
                    if (name.length() > 0)
                        name = name.replace(" ", "+");
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

        String url = getLink(command);
        if (url != null)
            try {
                desktop.browse(new URI(url));
            } catch (URISyntaxException | IOException e) {}
        else {
            BrowserFrame browser = new BrowserFrame("https://www.google.com/search?q=" + command);
            browser.setVisible(true);
            browser.setBounds(190, 90, 1030, 600);
            browser.setTitle("Google");
        }         
    }
}