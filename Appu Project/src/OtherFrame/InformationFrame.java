
package OtherFrame;

import Shape.CircleLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InformationFrame extends JFrame {
    private static JButton exitButton;   
    private JLabel iconLabel, versionLabel, infoLabel;
    
    private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
    
    private void setExitButton() {
        exitButton = new JButton("Exit") {
            int radius = 20;
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
                super.paintComponent(g);
            }
            @Override
            protected void paintBorder(Graphics g) {
                g.setColor(getForeground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
            }
            @Override
            public boolean contains(int x, int y) {
                Shape shape = null;
                if (shape == null || !shape.getBounds().equals(getBounds()))
                    shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
                return shape.contains(x, y);
            }
        };
        exitButton.setBounds(110, 260, 80, 30);
        exitButton.setOpaque(false);  
        exitButton.setBackground(new Color(0, 0, 51));
        exitButton.setForeground(Color.WHITE);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
    }

    private void setIcon() {
        iconLabel = new JLabel();
        try {                      
            BufferedImage image = ImageIO.read(new File("src/Pictures/Avatar.jpg"));
            iconLabel.setIcon(CircleLabel.setImageLabel(resize(image, 50, 50)));
        } catch (IOException ex) {}
        iconLabel.setBounds(125, 10, 60, 60);
        add(iconLabel);
        versionLabel = new JLabel("Version 2.1.7");
        versionLabel.setBounds(105, iconLabel.getHeight() + 5, 100, 30);
        versionLabel.setFont(new Font("Arial", 3, 14));
        versionLabel.setForeground(Color.WHITE);
        add(versionLabel);
    }
    
    private void setInfo() {
        infoLabel = new JLabel();
        infoLabel.setBounds(10, 65, 280, 170);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Arial", 3, 14));
        infoLabel.setText("<html>xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx "
                            + "xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx "
                            + "xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx "
                            + "xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx xxx</html>");
        add(infoLabel);
    }

    public InformationFrame() {
        try {
            setIconImage(ImageIO.read(InformationFrame.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}
        setSize(300, 300);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/Pictures/Info.jpg")))));
        } catch (IOException ex) {}
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 300, 300, 50, 50));
        
        setExitButton();
        setIcon();
        setInfo();
    }
}
