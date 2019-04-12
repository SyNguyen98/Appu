
package OtherFrame;

import MainFrame.TitlePanel;
import Shape.CircleButton;
import Shape.CircleLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InformationFrame extends JFrame {
    private static JButton exitButton;   
    private JLabel iconLabel, versionLabel, infoLabel;
    
    private void setExitButton() {
        exitButton = new CircleButton();
        try {
            Image image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Exit.png"));
            exitButton.setIcon(new ImageIcon(image));
        } catch (IOException ex) {}
        exitButton.setBounds(265, 5, 30, 30);
        exitButton.setToolTipText("Exit");
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
            BufferedImage image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Avatar.jpg"));
            iconLabel.setIcon(CircleLabel.setImageLabel(image));
        } catch (IOException ex) {}
        iconLabel.setBounds(125, 10, 60, 60);
        add(iconLabel);
        versionLabel = new JLabel("Version 2.1.6");
        versionLabel.setBounds(105, 65, 100, 30);
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
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 300, 300, 50, 50));
        
        setExitButton();
        setIcon();
        setInfo();
    }
}
