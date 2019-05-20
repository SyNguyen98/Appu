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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class InputPanel extends JPanel {

    public static final JTextField inputField = new RoundTextField("");
    private static JButton suggestiveButton;
    private JPopupMenu suggestiveMenu;

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
        String path = "";
        if ("english".equals(MainFrame.getLanguage())) {         
            inputField.setText("Say something ...");
            path = "src/Database/SuggestionEnglish.txt";
        }
        else {
            inputField.setText("Hãy nói gì đi ...");
            path = "src/Database/SuggestionVietnamese.txt";
        }
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
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
        inputField.setBackground(new Color(0, 0, 51));
        inputField.setForeground(Color.WHITE);
        inputField.setFont(new Font("Arial", 2, 14));
        inputField.setHorizontalAlignment(RoundTextField.CENTER);
        inputField.setFocusTraversalKeysEnabled(false);
        add(inputField);
    }

    private void setSuggestiveButton() {
        suggestiveButton = new CircleButton();
        suggestiveButton.setIcon(new ImageIcon("src/Pictures/mention-icon.png"));
        suggestiveButton.setBounds(410, 20, 40, 40);
        suggestiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if ("english".equals(MainFrame.getLanguage()))
                    suggestiveMenu = new SuggestiveMenu("english");
                else
                    suggestiveMenu = new SuggestiveMenu("vietNam");
                suggestiveMenu.show(suggestiveButton, 0, -suggestiveMenu.getHeight());
            }
        });
        add(suggestiveButton);
    }

    public InputPanel() {
        setBounds(0, 560, 480, 80);
        setLayout(new GroupLayout(this));
        setInputTextField();
        setSuggestiveButton();
    }
}
