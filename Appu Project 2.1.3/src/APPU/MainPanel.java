package APPU;

import Shape.RoundPanel;
import Shape.CircleLabel;
import Command.Autocomplete;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class MainPanel extends JPanel {
    public static final JTextField inputField = new Shape.RoundTextField();
    public static JLabel commandLabel, answerLabel, iconLabel, timeLabel;
    public static JPanel commandPanel, answerPanel, mainPanel;
    public static JScrollPane scrollPane = new JScrollPane();
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = null;
        try {                
            image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Main.jpg"));
        } catch (IOException ex) {
            ex.getMessage();
        }
        g.drawImage(image, 0, 0, this);         
    }
    
    public static void setTime() {
        timeLabel = new JLabel(); 
        timeLabel.setForeground(Color.LIGHT_GRAY);
        timeLabel.setFont(new Font("Arial", 1, 12));
    }
    
    public static void setCommand() {
        commandPanel = new RoundPanel();
        commandPanel.setLayout(new GroupLayout(commandPanel));
        commandPanel.setOpaque(false);
        commandPanel.setBackground(Color.CYAN);
        
        commandLabel = new JLabel();
        commandLabel.setFont(new Font("Arial", 3, 14));
        commandLabel.setForeground(Color.BLACK);
        commandPanel.add(commandLabel);
    }
    
    public static void setAnswer() {
        iconLabel = new JLabel();
        try {
            BufferedImage image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Meido.jpg"));
            iconLabel.setIcon(CircleLabel.setImageLabel(image));
        } catch (IOException ex) {} 
        answerPanel = new RoundPanel();
        answerPanel.setLayout(new GroupLayout(answerPanel));
        answerPanel.setOpaque(false);
        answerPanel.setBackground(Color.BLUE);
        
        answerLabel = new JLabel();
        answerLabel.setFont(new Font("Arial", 3, 14));
        answerLabel.setForeground(Color.WHITE);
        answerLabel.setBounds(10, 10, 170, 20);
        answerPanel.add(answerLabel);
    }
    
    public static void setScrollPane() {
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                BufferedImage image = null;
                try {                
                    image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Main.jpg"));
                } catch (IOException ex) {}
                g.drawImage(image, 0, 0, this);         
            }
        };
        mainPanel.setBounds(0, 0, 480, 3000);
        mainPanel.setLayout(null);
        
        scrollPane.setSize(500, 480);
        scrollPane.add(mainPanel);
        scrollPane.setViewportView(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
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
        
        Autocomplete autoComplete = new Autocomplete(inputField, keywords);
        
        inputField.setBounds(20, 490, 370, 50);
        inputField.setOpaque(false);
        inputField.setFont(new Font("Arial", 2, 16));
        inputField.setFocusTraversalKeysEnabled(false);
        inputField.getDocument().addDocumentListener(autoComplete);
        inputField.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "commit");
        inputField.getActionMap().put("commit", autoComplete.new CommitAction());
    }
    
    public MainPanel() {
        setInputTextField();
        add(inputField);
        
        setScrollPane();
        add(scrollPane);

        setLayout(new GroupLayout(this));
        setBounds(0, 60, 480, 580);   
    }
}