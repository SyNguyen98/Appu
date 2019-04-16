package MainFrame;

import Setting.AutoComplete;
import Shape.CircleButton;
import Shape.RoundTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class InputPanel extends JPanel {
    public static final RoundTextField inputField = new RoundTextField("Say something...");
    private static JButton mensionButton;
    
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

    private void setInputTextField() {
         List<String> keywords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Database/KeyAutoComplete.txt"))) {
            String line = br.readLine(); 
            while (line != null) {
                keywords.add(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {}
        AutoComplete autoComplete = new AutoComplete(inputField, keywords);
        
        inputField.setBounds(30, 15, 350, 50);
        inputField.setOpaque(false);       
        inputField.setBackground(new Color(0,0,51));
        inputField.setForeground(Color.WHITE);
        inputField.setFont(new Font("Arial", 2, 14));
        inputField.setHorizontalAlignment(RoundTextField.CENTER);
        inputField.setFocusTraversalKeysEnabled(false);
        inputField.getDocument().addDocumentListener(autoComplete);
        inputField.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "commit");
        inputField.getActionMap().put("commit", autoComplete.new CommitAction());
        add(inputField);
    }

    private void setMensionButton() {
        mensionButton = new CircleButton();
        mensionButton.setIcon(new ImageIcon("src/Pictures/Exit.png"));
        mensionButton.setBounds(410, 20, 40, 40);
        add(mensionButton);
    }
        
    public InputPanel() {
        setBounds(0, 560, 480, 80);
        setLayout(new GroupLayout(this));       
        setInputTextField();
        setMensionButton();
    }
}
