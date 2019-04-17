package Setting;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class MentionMenu extends JPopupMenu {  
    public MentionMenu() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Database/KeyAutoComplete.txt"))) {
            String line = br.readLine(); 
            while (line != null) {
                JMenuItem item = new JMenuItem();     
                item.setOpaque(false);
                item.setText(line);
                item.setFont(new Font("Arial", 1, 12));
                item.setBackground(new Color(0, 0, 51));
                item.setForeground(Color.WHITE);
                item.setHorizontalTextPosition(JMenuItem.LEFT);
                add(item);           
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {}
    }
}
