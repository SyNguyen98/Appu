package Setting;

import MainFrame.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SuggestiveMenu extends JPopupMenu {

    private static final JSONParser parser = new JSONParser();

    public SuggestiveMenu() {
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new InputStreamReader(SuggestiveMenu.class.getResourceAsStream("/Database/Keyword.json")));
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;              
                JMenuItem item = new JMenuItem();
                if ("english".equals(MainFrame.getLanguage()))
                    item.setText((String) jsonObject.get("Eng"));
                else
                    item.setText((String) jsonObject.get("Viet"));
                item.setFont(new Font("Arial", 1, 12));
                item.setOpaque(true);
                item.setBackground(new Color(0, 0, 51));
                item.setForeground(Color.WHITE);
                item.setHorizontalTextPosition(JMenuItem.LEFT);
                add(item);

            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {}
        setBorder(BorderFactory.createEmptyBorder());
    }
}
