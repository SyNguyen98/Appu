package MainFrame;

import Shape.RoundPanel;
import Shape.CircleLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainPanel extends JScrollPane {
    public static JLabel commandLabel, answerLabel, iconLabel, timeLabel;
    public static JPanel commandPanel, answerPanel, mainPanel;
    
    private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    } 
    
    public static void setTimeLabel() {
        timeLabel = new JLabel(); 
        timeLabel.setForeground(Color.LIGHT_GRAY);
        timeLabel.setFont(new Font("Arial", 1, 12));
    }
    
    public static void setCommandPanel() {
        commandPanel = new RoundPanel();
        commandPanel.setLayout(new GroupLayout(commandPanel));
        commandPanel.setOpaque(false);
        commandPanel.setBackground(Color.CYAN);
        
        commandLabel = new JLabel();
        commandLabel.setFont(new Font("Arial", 3, 14));
        commandLabel.setForeground(Color.BLACK);
        commandPanel.add(commandLabel);
    }
    
    public static void setAnswerPanel() {
        iconLabel = new JLabel();
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/Pictures/Avatar.jpg"));
            iconLabel.setIcon(CircleLabel.setImageLabel(resize(image, 35, 35)));
        } catch (IOException ex) {} 
        answerPanel = new RoundPanel();
        answerPanel.setLayout(new GroupLayout(answerPanel));
        answerPanel.setOpaque(false);
        answerPanel.setBackground(Color.BLUE);
        
        answerLabel = new JLabel();
        answerLabel.setFont(new Font("Arial", 3, 14));
        answerLabel.setForeground(Color.WHITE);
        answerPanel.add(answerLabel);
    }
    
    public MainPanel() {
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                BufferedImage image = null;
                try {                
                    image = ImageIO.read(new File("src/Pictures/Main.jpg"));
                } catch (IOException ex) {}
                g.drawImage(image, 0, 0, this);         
            }
        };
        mainPanel.setBounds(0, 0, 480, 3000);
        mainPanel.setLayout(null);

        setBounds(0, 60, 500, 500);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(mainPanel);
        setViewportView(mainPanel);   
    }
}