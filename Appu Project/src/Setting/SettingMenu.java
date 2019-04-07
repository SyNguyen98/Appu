package Setting;

import MainFrame.TitlePanel;
import OtherFrame.GuideFrame;
import OtherFrame.InformationFrame;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class SettingMenu extends JPopupMenu {
    private static JMenuItem avatarItem, nameItem, helpItem, infoItem, driveItem;
    private static final GuideFrame guideFrame = new GuideFrame();
    private static final InformationFrame infoFrame = new InformationFrame();
    
    private static void changeAvatar() {
        avatarItem = new JMenuItem(" Change Avatar");
        avatarItem.setFont(new Font("Arial", 1, 15));
        avatarItem.setIcon(new ImageIcon(TitlePanel.class.getResource("/Pictures/avatar-icon.png")));
        avatarItem.setBackground(Color.CYAN);
        avatarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ChangeAvatar.setAvatar();
            }
        });
    }
    
    private static void changeName() {
        nameItem = new JMenuItem(" Change Name");
        nameItem.setFont(new Font("Arial", 1, 15));
        nameItem.setIcon(new ImageIcon(TitlePanel.class.getResource("/Pictures/name-icon.png")));
        nameItem.setBackground(Color.ORANGE);
        nameItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String name = JOptionPane.showInputDialog(null);
                TitlePanel.nameLabel.setText(name);
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Pictures/Name.txt"))) {
                    bw.write(name);
                } catch (IOException ex) {}
            }
        });
    }
    
    private static void help() {
        helpItem = new JMenuItem(" Help");
        helpItem.setFont(new Font("Arial", 1, 15));
        helpItem.setIcon(new ImageIcon(TitlePanel.class.getResource("/Pictures/help-icon.png")));
        helpItem.setBackground(Color.YELLOW);
        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                guideFrame.setVisible(true);
            }
        });
    }
    
    private static void setInformation() {
        infoItem = new JMenuItem(" Information");
        infoItem.setFont(new Font("Arial", 1, 15));
        infoItem.setIcon(new ImageIcon(TitlePanel.class.getResource("/Pictures/i-icon.png")));
        infoItem.setBackground(Color.WHITE);
        infoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                infoFrame.setVisible(true);
            }
        });
    }
    
    private static void setDrive() {
        driveItem = new JMenuItem(" Drive");
        driveItem.setFont(new Font("Arial", 1, 15));
        driveItem.setIcon(new ImageIcon(TitlePanel.class.getResource("/Pictures/drive-icon.png")));
        driveItem.setBackground(Color.GREEN);
        driveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI("http://bit.ly/drivelop16vlth"));
                } catch (IOException | URISyntaxException ex) {}
            }
        });
    }
    
    public SettingMenu() {
        changeAvatar();
        add(avatarItem);
        changeName();
        add(nameItem);
        help();
        add(helpItem);
        setInformation();
        add(infoItem);
        setDrive();
        add(driveItem);
    }
}