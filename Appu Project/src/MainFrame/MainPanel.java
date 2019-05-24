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

public class MainPanel extends JPanel {
    public static JLabel commandLabel, answerLabel, iconLabel, timeLabel;
    public static JPanel commandPanel, answerPanel;
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            BufferedImage image = ImageIO.read(new File("src/Pictures/Main.jpg"));
            g.drawImage(image, 0, 0, this);
        } catch (IOException ex) {}
    }
    
    private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    } 
    
    public void setTimeLabel() {
        timeLabel = new JLabel(); 
        timeLabel.setBounds(225, 0, 50, 40);
        timeLabel.setForeground(Color.LIGHT_GRAY);
        timeLabel.setFont(new Font("Arial", 1, 12));
        add(timeLabel);
    }
    
    public void setCommandPanel() {
        commandPanel = new RoundPanel();
        commandPanel.setLayout(new GroupLayout(commandPanel));
        commandPanel.setOpaque(false);
        commandPanel.setBackground(Color.CYAN);
        
        commandLabel = new JLabel();
        commandLabel.setFont(new Font("Arial", 3, 13));
        commandLabel.setForeground(Color.BLACK);
        commandPanel.add(commandLabel);
        add(commandPanel);
    }
    
    public void setAnswerPanel() {
        iconLabel = new JLabel();
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/Pictures/Avatar.jpg"));
            iconLabel.setIcon(CircleLabel.setImageLabel(resize(image, 35, 35)));
        } catch (IOException ex) {} 
        add(iconLabel);
        
        answerPanel = new RoundPanel();
        answerPanel.setLayout(new GroupLayout(answerPanel));
        answerPanel.setOpaque(false);
        answerPanel.setBackground(Color.BLUE);
        
        answerLabel = new JLabel();
        answerLabel.setFont(new Font("Arial", 3, 13));
        answerLabel.setForeground(Color.WHITE);
        answerPanel.add(answerLabel);
        add(answerPanel);
    }
    
    public MainPanel() {
        setLayout(new GroupLayout(this));
        setBounds(0, 60, 480, 500);
        
        setTimeLabel() ;
        setCommandPanel();
        setAnswerPanel();
    }
}