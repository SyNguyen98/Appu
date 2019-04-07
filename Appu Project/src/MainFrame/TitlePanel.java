package MainFrame;

import OtherFrame.InformationFrame;
import Command.ChangeAvatar;
import Shape.CircleButton;
import Shape.CircleLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class TitlePanel extends JPanel {
    public static JLabel imageLabel, nameLabel;
    private static JButton infoButton, settingButton;
    private static final JFrame infoFrame = new InformationFrame();
    private static final JPopupMenu settingMenu = new SettingMenu();

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
    
    private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    } 
    
    private void setInfoButton() {
        infoButton = new CircleButton();
        try {
            Image image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Exclamation.jpg"));
            infoButton.setIcon(new ImageIcon(image));
        } catch (IOException ex) {}
        infoButton.setBounds(430, 15, 30, 30);
        infoButton.setToolTipText("App's information");
        add(infoButton);
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                infoFrame.setVisible(true);
            }
        });
    }
    
    private void setSettingButton() {
        settingButton = new CircleButton();
        try {
            Image image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Gear.png"));
            settingButton.setIcon(new ImageIcon(image));
        } catch (IOException ex) {}
        settingButton.setBounds(380, 15, 30, 30);
        settingButton.setToolTipText("Setting");
        add(settingButton);
        settingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                settingMenu.show(settingButton, -settingMenu.getWidth() + settingButton.getWidth(), settingButton.getHeight() + 5);
            }
        });
    }
    
    private void setAvatarLabel() {
        imageLabel = new JLabel();
        BufferedImage image = null;
        try {                      
            image = ImageIO.read(new File("src/Pictures/Avatar.jpg"));
            imageLabel.setIcon(CircleLabel.setImageLabel(resize(image, 50, 50)));
//            imageLabel.setIcon(CircleLabel.setImageLabel(image));
        } catch (IOException ex) {}
        imageLabel.setBounds(20, 5, 50, 50);
        add(imageLabel);
    }
    
    private void setNameLabel() {
        nameLabel = new JLabel();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Pictures/Name.txt"))) {
            String name = br.readLine();
            nameLabel.setText(name);
        } catch (IOException ex) {}
        
        nameLabel.setBounds(85, 6, 100, 50);
        nameLabel.setFont(new Font("Arial", 3, 16));
        nameLabel.setForeground(Color.WHITE);
        add(nameLabel);
    }
    
    public TitlePanel() {       
        setBounds(0, 0, 480, 60);
        setLayout(new GroupLayout(this));
        
        setAvatarLabel();
        setNameLabel();
        setInfoButton();
        setSettingButton();
    }
}