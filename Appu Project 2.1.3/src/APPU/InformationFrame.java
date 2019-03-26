
package APPU;

import Shape.CircleLabel;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InformationFrame extends JFrame {
    private JLabel iconLabel, versionLabel, 
                   dev1Label, dev2Label, dev3Label,
                   name1Label, name2Label, name3Label;

    private void setIconLabel() {
        iconLabel = new JLabel();
        try {
            iconLabel.setIcon(CircleLabel.setImageLabel(ImageIO.read(TitlePanel.class.getResource("/Pictures/Appu.jpg"))));
        } catch (IOException ex) {}
        iconLabel.setBounds(115, 10, 70, 70);
        this.add(iconLabel);
        versionLabel = new JLabel("Version 2.1.3");
        versionLabel.setBounds(105, 65, 100, 40);
        versionLabel.setFont(new Font("Arial", 3, 14));
        versionLabel.setForeground(Color.WHITE);
        this.add(versionLabel);
    }
    
    private void setDevLabel() {
        dev1Label = new JLabel();
        try {
            dev1Label.setIcon(CircleLabel.setImageLabel(ImageIO.read(TitlePanel.class.getResource("/Pictures/Nguyen.jpg"))));
        } catch (IOException ex) {}
        dev1Label.setBounds(115, 130, 70, 70);
        this.add(dev1Label);
        name1Label = new JLabel("Sỹ Nguyên");
        name1Label.setBounds(115, 188, 100, 40);
        name1Label.setFont(new Font("Arial", 3, 14));
        name1Label.setForeground(Color.BLACK);
        this.add(name1Label);

        dev2Label = new JLabel();
        try {
            dev2Label.setIcon(CircleLabel.setImageLabel(ImageIO.read(TitlePanel.class.getResource("/Pictures/Tung.jpg"))));
        } catch (IOException ex) {}
        dev2Label.setBounds(10, 130, 70, 70);
        this.add(dev2Label);
        name2Label = new JLabel("Thanh Tùng");
        name2Label.setBounds(3, 188, 100, 40);
        name2Label.setFont(new Font("Arial", 3, 14));
        name2Label.setForeground(Color.BLACK);
        this.add(name2Label);
        
        dev3Label = new JLabel();
        try {
            dev3Label.setIcon(CircleLabel.setImageLabel(ImageIO.read(TitlePanel.class.getResource("/Pictures/Dang.jpg"))));
        } catch (IOException ex) {}
        dev3Label.setBounds(210, 130, 70, 70);
        this.add(dev3Label);
        name3Label = new JLabel("Hải Đăng");
        name3Label.setBounds(212, 188, 100, 40);
        name3Label.setFont(new Font("Arial", 3, 14));
        name3Label.setForeground(Color.BLACK);
        this.add(name3Label);
        
    }

    public InformationFrame() {
        setIconLabel();
        setDevLabel();
        add(new JLabel(new ImageIcon(InformationFrame.class.getResource("/Pictures/Info.jpg"))));
        setTitle("Info of Developers");
        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        try {
            setIconImage(ImageIO.read(InformationFrame.class.getResource("/Pictures/Icon.jpg")));
        } catch (IOException ex) {}
    }
}
