package Setting;

import OtherFrame.GuideFrame;
import OtherFrame.InformationFrame;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SettingMenu extends JPopupMenu {
    private static JMenuItem avatarItem, nameItem, helpItem, infoItem, driveItem;
    private static final GuideFrame guideFrame = new GuideFrame();
    private static final JFrame infoFrame = new InformationFrame();
    private static FrameDrag frameDrag;

    private void changeAvatar() {
        avatarItem = new JMenuItem(" Change Avatar");
        avatarItem.setFont(new Font("Arial", 1, 15));
        avatarItem.setIcon(new ImageIcon("src/Pictures/avatar-icon.png"));
        avatarItem.setBackground(new Color(0, 0, 51));
        avatarItem.setForeground(Color.WHITE);
        avatarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ChangeInfo.setAvatar();
            }
        });
        add(avatarItem);
    }
    
    private void changeName() {
        nameItem = new JMenuItem(" Change Name");
        nameItem.setFont(new Font("Arial", 1, 15));
        nameItem.setIcon(new ImageIcon("src/Pictures/name-icon.png"));
        nameItem.setBackground(new Color(0, 0, 102));
        nameItem.setForeground(Color.WHITE);
        nameItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ChangeInfo.setName();
            }
        });
        add(nameItem);
    }
    
    private void help() {
        helpItem = new JMenuItem(" Help");
        helpItem.setFont(new Font("Arial", 1, 15));
        helpItem.setIcon(new ImageIcon("src/Pictures/help-icon.png"));
        helpItem.setBackground(new Color(0, 0, 153));
        helpItem.setForeground(Color.WHITE);
        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                guideFrame.setVisible(true);
                frameDrag = new FrameDrag(guideFrame);
                guideFrame.addMouseListener(frameDrag);
                guideFrame.addMouseMotionListener(frameDrag);
            }
        });
        add(helpItem);
    }
    
    private void information() {
        infoItem = new JMenuItem(" Information");
        infoItem.setFont(new Font("Arial", 1, 15));
        infoItem.setIcon(new ImageIcon("src/Pictures/i-icon.png"));
        infoItem.setBackground(new Color(0, 0, 204));
        infoItem.setForeground(Color.WHITE);
        infoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                infoFrame.setVisible(true);
                frameDrag = new FrameDrag(infoFrame);
                infoFrame.addMouseListener(frameDrag);
                infoFrame.addMouseMotionListener(frameDrag);
            }
        });
        add(infoItem);
    }
    
    private void drive() {
        driveItem = new JMenuItem(" Drive");
        driveItem.setFont(new Font("Arial", 1, 15));
        driveItem.setIcon(new ImageIcon("src/Pictures/drive-icon.png"));
        driveItem.setBackground(new Color(0, 0, 255));
        driveItem.setForeground(Color.WHITE);
        driveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI("http://bit.ly/drivelop16vlth"));
                } catch (IOException | URISyntaxException ex) {}
            }
        });
        add(driveItem);
    }

    public SettingMenu() {
        changeAvatar();
        changeName();
        help();
        information();
        drive();  
    }
}