package Performance;

import Database.EngSQL;
import Database.VietSQL;
import OtherFrame.BrowserFrame;
import MainFrame.InputPanel;
import MainFrame.MainFrame;
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
            JSONArray jsonArray = (JSONArray) parser.parse(new InputStreamReader(Internet.class.getResourceAsStream("/Database/Website.json")));
            for (Object obj : jsonArray) {                 
                JSONObject jsonObject = (JSONObject) obj;   
                String key = "";
                if ("english".equals(MainFrame.getLanguage()))
                    key = (String) jsonObject.get("Eng");
                else
                    key = (String) jsonObject.get("Viet");
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
        String command = InputPanel.inputField.getText().toLowerCase();
        String url = getLink(command);
        if (url != null)
            try {
                desktop.browse(new URI(url));
            } catch (URISyntaxException | IOException e) {}
        
        else if (EngSQL.exceptionCase(command).equals("error") && VietSQL.exceptionCase(command).equals("error")) {
            BrowserFrame browser = new BrowserFrame("https://www.google.com/search?q=" + command);
            browser.setVisible(true);
            browser.setBounds(190, 90, 1030, 600);
            browser.setTitle("Google");    
        }
    }
}