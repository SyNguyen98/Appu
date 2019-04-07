
package OtherFrame;

import MainFrame.TitlePanel;
import Shape.CircleLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InformationFrame extends JFrame {
    private JLabel iconLabel, versionLabel, infoLabel,
                   dev1Label, dev2Label, dev3Label,
                   name1Label, name2Label, name3Label;

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
//        dev1Label = new JLabel();
//        try {
//            BufferedImage image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Nguyen.jpg"));
//            dev1Label.setIcon(CircleLabel.setImageLabel(image));
//        } catch (IOException ex) {}
//        dev1Label.setBounds(115, 130, 70, 70);
//        this.add(dev1Label);
//        name1Label = new JLabel("Sỹ Nguyên");
//        name1Label.setBounds(115, 188, 100, 40);
//        name1Label.setFont(new Font("Arial", 3, 14));
//        name1Label.setForeground(Color.BLACK);
//        this.add(name1Label);
//
//        dev2Label = new JLabel();
//        try {
//            BufferedImage image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Tung.jpg"));
//            dev2Label.setIcon(CircleLabel.setImageLabel(image));
//        } catch (IOException ex) {}
//        dev2Label.setBounds(10, 130, 70, 70);
//        this.add(dev2Label);
//        name2Label = new JLabel("Thanh Tùng");
//        name2Label.setBounds(3, 188, 100, 40);
//        name2Label.setFont(new Font("Arial", 3, 14));
//        name2Label.setForeground(Color.BLACK);
//        this.add(name2Label);
//        
//        dev3Label = new JLabel();
//        try {
//            BufferedImage image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Dang.jpg"));
//            dev3Label.setIcon(CircleLabel.setImageLabel(image));
//        } catch (IOException ex) {}
//        dev3Label.setBounds(210, 130, 70, 70);
//        this.add(dev3Label);
//        name3Label = new JLabel("Hải Đăng");
//        name3Label.setBounds(212, 188, 100, 40);
//        name3Label.setFont(new Font("Arial", 3, 14));
//        name3Label.setForeground(Color.BLACK);
//        this.add(name3Label);
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
        setIcon();
        setInfo();
        add(new JLabel(new ImageIcon(InformationFrame.class.getResource("/Pictures/Info.jpg"))));
        setTitle("App's Information");
        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        try {
            setIconImage(ImageIO.read(InformationFrame.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}
    }
}
