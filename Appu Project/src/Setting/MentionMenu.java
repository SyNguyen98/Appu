package Setting;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class MentionMenu extends JPopupMenu {
    private static JMenuItem video, picture, map, music, translate;
    
    public MentionMenu() {
        video = new JMenuItem("#video");
        video.setFont(new Font("Arial", 1, 12));
        video.setBackground(new Color(0, 0, 51));
        video.setForeground(Color.WHITE);
        add(video);
        setOpaque(false);
        setBorderPainted(false);
    }
}
