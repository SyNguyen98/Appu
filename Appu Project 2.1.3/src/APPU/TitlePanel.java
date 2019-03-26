package APPU;

import Shape.CircleButton;
import Shape.CircleLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {
    public static JLabel imageLabel, nameLabel;
    private static JButton infoButton;
    private static final JFrame infoFrame = new InformationFrame();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = null;
        try {                
            image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Title.jpg"));
        } catch (IOException ex) {
            ex.getMessage();
        }
        g.drawImage(image, 0, 0, this);         
    }
    
    public TitlePanel() {
        setBounds(0, 0, 480, 60);
        setLayout(new GroupLayout(this));
        try {
            imageLabel = CircleLabel.setImageLabel(imageLabel, TitlePanel.class.getResource("/Pictures/Appu.jpg"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        imageLabel.setBounds(20, 5, 50, 50);
        add(imageLabel);
        
        nameLabel = new JLabel("Appu - tan");
        nameLabel.setBounds(85, 6, 100, 50);
        nameLabel.setFont(new Font("Arial", 3, 16));
        nameLabel.setForeground(Color.WHITE);
        add(nameLabel);
        
        infoButton = new CircleButton();
        try {
            Image image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Exclamation.jpg"));
            infoButton.setIcon(new ImageIcon(image));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        infoButton.setBackground(Color.BLUE);
        infoButton.setBounds(430, 15, 30, 30);
        infoButton.setToolTipText("Information of Developments");
        add(infoButton);
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                infoFrame.setVisible(true);
            }
        });
    }
}