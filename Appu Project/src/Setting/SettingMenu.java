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
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SettingMenu extends JPopupMenu {
    public static JMenu infoMenu, languageMenu;
    public static JMenuItem avatarItem, nameItem, guideItem, infoItem, englishItem, vietnameseItem, driveItem;
    private static final GuideFrame guideFrame = new GuideFrame();
    private static final JFrame infoFrame = new InformationFrame();
    private static FrameDrag frameDrag;
    
    private void changeInfo() {
        infoMenu = new JMenu("Change Info");
        infoMenu.setFont(new Font("Arial", 1, 15));
        infoMenu.setIcon(new ImageIcon("src/Pictures/avatar-icon.png"));
        infoMenu.setOpaque(true);
        infoMenu.setBackground(new Color(0, 0, 51));
        infoMenu.setForeground(Color.WHITE);
        changeAvatar();
        changeName();
        add(infoMenu);
    }

    private void changeAvatar() {
        avatarItem = new JMenuItem("Change Avatar");
        avatarItem.setFont(new Font("Arial", 1, 15));
        avatarItem.setIcon(new ImageIcon("src/Pictures/avatar-icon.png"));
        avatarItem.setBackground(new Color(102,0,102));
        avatarItem.setForeground(Color.WHITE);
        avatarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ChangeInfo.setAvatar();
            }
        });
        infoMenu.add(avatarItem);
    }
    
    private void changeName() {
        nameItem = new JMenuItem("Change Name");
        nameItem.setFont(new Font("Arial", 1, 15));
        nameItem.setIcon(new ImageIcon("src/Pictures/name-icon.png"));
        nameItem.setBackground(new Color(102,0,153));
        nameItem.setForeground(Color.WHITE);
        nameItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ChangeInfo.setName();
            }
        });
        infoMenu.add(nameItem);
    }
    
    private void setGuide() {
        guideItem = new JMenuItem(" Help");
        guideItem.setFont(new Font("Arial", 1, 15));
        guideItem.setIcon(new ImageIcon("src/Pictures/help-icon.png"));
        guideItem.setBackground(new Color(0, 0, 153));
        guideItem.setForeground(Color.WHITE);
        guideItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                guideFrame.setVisible(true);
                frameDrag = new FrameDrag(guideFrame);
                guideFrame.addMouseListener(frameDrag);
                guideFrame.addMouseMotionListener(frameDrag);
            }
        });
        add(guideItem);
    }
    
    private void getInformation() {
        infoItem = new JMenuItem("Information");
        infoItem.setFont(new Font("Arial", 1, 15));
        infoItem.setIcon(new ImageIcon("src/Pictures/info-icon.png"));
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
    
    private void changLanguage() {
        languageMenu = new JMenu("Language");
        languageMenu.setFont(new Font("Arial", 1, 15));
        languageMenu.setIcon(new ImageIcon("src/Pictures/info-icon.png"));
        languageMenu.setOpaque(true);
        languageMenu.setBackground(new Color(0, 0, 255));
        languageMenu.setForeground(Color.WHITE);
        setEnglish();
        setVietnamese();
        add(languageMenu);
    }
    
    private void setEnglish() {
        englishItem = new JMenuItem("English");
        englishItem.setFont(new Font("Arial", 1, 15));
        englishItem.setBackground(new Color(0, 0, 51));
        englishItem.setForeground(Color.WHITE);
        englishItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Language.setEnglish();
            }
        });
        languageMenu.add(englishItem);
    }
    
    private void setVietnamese() {
        vietnameseItem = new JMenuItem("Tiếng Việt");
        vietnameseItem.setFont(new Font("Arial", 1, 15));
        vietnameseItem.setBackground(new Color(0, 0, 102));
        vietnameseItem.setForeground(Color.WHITE);
        vietnameseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Language.setVietnamese();
            }
        });
        languageMenu.add(vietnameseItem);
    }
    
    private void accessDrive() {
        driveItem = new JMenuItem("Drive");
        driveItem.setFont(new Font("Arial", 1, 15));
        driveItem.setIcon(new ImageIcon("src/Pictures/drive-icon.png"));
        driveItem.setBackground(new Color(51,51,255));
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
        changeInfo();
        setGuide();
        getInformation();
        changLanguage();
        accessDrive();
    }
}