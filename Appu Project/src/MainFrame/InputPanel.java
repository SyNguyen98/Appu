package MainFrame;

import Setting.AutoSuggestor;
import Setting.SuggestiveMenu;
import Shape.CircleButton;
import Shape.RoundTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class InputPanel extends JPanel {
    public static final JTextField inputField = new RoundTextField("Say something...");
    private static JButton mentionButton;
    private static final JPopupMenu mentionMenu = new SuggestiveMenu();
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {                
            BufferedImage image = ImageIO.read(new File("src/Pictures/Input.jpg"));
            g.drawImage(image, 0, 0, this);    
        } catch (IOException ex) {}     
    }

    private void setInputTextField() {
        List<String> keywords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Database/Suggestion.txt"))) {
            String line = br.readLine(); 
            while (line != null) {
                keywords.add(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {}
        
        AutoSuggestor autoSuggestor = new AutoSuggestor(inputField, MainFrame.frame, null, new Color(0, 0, 102), Color.WHITE, Color.WHITE, 0.75f) {
            @Override
            public boolean wordTyped(String typedWord) {
                setDictionary(keywords);
                return super.wordTyped(typedWord);
            }
        };
        
        inputField.setBounds(30, 15, 350, 50);
        inputField.setOpaque(false);       
        inputField.setBackground(new Color(0,0,51));
        inputField.setForeground(Color.WHITE);
        inputField.setFont(new Font("Arial", 2, 14));
        inputField.setHorizontalAlignment(RoundTextField.CENTER);
        inputField.setFocusTraversalKeysEnabled(false);
        add(inputField);
    }

    private void setMentionButton() {
        mentionButton = new CircleButton();
        mentionButton.setIcon(new ImageIcon("src/Pictures/mention-icon.png"));
        mentionButton.setBounds(410, 20, 40, 40);
        mentionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                UIManager.put("PopupMenu.background", new Color(0, 0, 51));
                UIManager.put("PopupMenu.border", BorderFactory.createEmptyBorder());
                mentionMenu.show(mentionButton, 0, -mentionMenu.getHeight());
            }
        });
        add(mentionButton);
    }
        
    public InputPanel() {
        setBounds(0, 560, 480, 80);
        setLayout(new GroupLayout(this));       
        setInputTextField();
        setMentionButton();
    }
}
