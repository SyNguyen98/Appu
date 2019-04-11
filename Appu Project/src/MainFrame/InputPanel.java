package MainFrame;

import Setting.Autocomplete;
import Shape.RoundTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class InputPanel extends JPanel {
    public static final RoundTextField inputField = new RoundTextField("Say something...");
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = null;
        try {                
            image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Input.jpg"));
        } catch (IOException ex) {
            ex.getMessage();
        }
        g.drawImage(image, 0, 0, this);         
    }
    
    private static void setInputTextField() {
        List<String> keywords = new ArrayList<>();
        keywords.add("video");
        keywords.add("picture");
        keywords.add("facebook");
        keywords.add("music");
        keywords.add("translate");
        keywords.add("map");
        keywords.add("anime");
        keywords.add("web");
        keywords.add("open");
        keywords.add("data structure");
        
        Autocomplete autoComplete = new Autocomplete(inputField, keywords);
        
        inputField.setBounds(30, 15, 350, 50);
        inputField.setOpaque(false);       
        inputField.setBackground(new Color(0,0,51));
        inputField.setForeground(Color.WHITE);
        inputField.setFont(new Font("Arial", 2, 14));
        inputField.setHorizontalAlignment(inputField.CENTER);
        inputField.setFocusTraversalKeysEnabled(false);
        inputField.getDocument().addDocumentListener(autoComplete);
        inputField.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "commit");
        inputField.getActionMap().put("commit", autoComplete.new CommitAction());
    }
        
    public InputPanel() {
        setBounds(0, 560, 480, 80);
        setLayout(new GroupLayout(this));       
        setInputTextField();
        add(inputField);
    }
}
