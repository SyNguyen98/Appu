package MainFrame;

import OtherFrame.MiniFrame;
import Setting.SettingMenu;
import Shape.CircleButton;
import Shape.CircleLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static JLabel imageLabel, nameLabel;
    private static JButton exitButton, settingButton;
    private static final SettingMenu settingMenu = new SettingMenu();
    private static final MiniFrame miniFrame = new MiniFrame();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = null;
        try {                
            image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Title.jpg"));
        } catch (IOException ex) {}
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
    
    private void setExitButton() {
        exitButton = new CircleButton();
        try {
            Image image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Exit.png"));
            exitButton.setIcon(new ImageIcon(image));
        } catch (IOException ex) {}
        exitButton.setBounds(430, 15, 30, 30);
        exitButton.setToolTipText("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
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
        try {                      
            BufferedImage image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Avatar.jpg"));
            imageLabel.setIcon(CircleLabel.setImageLabel(resize(image, 50, 50)));
        } catch (IOException ex) {}
        imageLabel.setBounds(20, 5, 50, 50);
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.frame.setVisible(false);
                miniFrame.setVisible(true);
                miniFrame.setLocation((int) screenSize.getWidth() - miniFrame.getWidth(), 25);
            } 
        });
        add(imageLabel);
    }
    
    private void setNameLabel() {
        nameLabel = new JLabel();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(TitlePanel.class.getResourceAsStream("/Database/Name.txt")))) {
            String name = br.readLine();
            nameLabel.setText(name);
        } catch (IOException ex) {}
        
        nameLabel.setBounds(85, 6, 150, 50);
        nameLabel.setFont(new Font("Arial", 3, 18));
        nameLabel.setForeground(Color.WHITE);
        add(nameLabel);
    }
    
    public TitlePanel() {       
        setBounds(0, 0, 480, 60);
        setLayout(new GroupLayout(this));
        
        setAvatarLabel();
        setNameLabel();
        setExitButton();
        setSettingButton();
    }
}