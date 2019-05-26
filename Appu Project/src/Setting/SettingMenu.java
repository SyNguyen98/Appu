package Setting;

import MainFrame.MainFrame;
import OtherFrame.GuideFrame;
import OtherFrame.InformationFrame;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SettingMenu extends JPopupMenu {

    public static JMenu infoMenu, languageMenu, otherMenu;
    public static JMenuItem avatarItem, nameItem, guideItem, infoItem, englishItem, vietnameseItem, driveItem, dataStructureItem;
    private static final GuideFrame guideFrame = new GuideFrame();
    private static final JFrame infoFrame = new InformationFrame();
    private static FrameDrag frameDrag;

    private void changeInfo() {
        infoMenu = new JMenu();
        infoMenu.setFont(new Font("Arial", 1, 15));
        infoMenu.setIcon(new ImageIcon(SettingMenu.class.getResource("/Pictures/settings-icon.png")));
        infoMenu.setOpaque(true);
        infoMenu.setBackground(new Color(0, 0, 42));
        infoMenu.setForeground(Color.WHITE);
        changeAvatar();
        changeName();
        add(infoMenu);
    }

    private void changeAvatar() {
        avatarItem = new JMenuItem();
        avatarItem.setFont(new Font("Arial", 1, 15));
        avatarItem.setIcon(new ImageIcon(SettingMenu.class.getResource("/Pictures/avatar-icon.png")));
        avatarItem.setBackground(new Color(102, 0, 102));
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
        nameItem = new JMenuItem();
        nameItem.setFont(new Font("Arial", 1, 15));
        nameItem.setIcon(new ImageIcon(SettingMenu.class.getResource("/Pictures/name-icon.png")));
        nameItem.setBackground(new Color(102, 0, 153));
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
        guideItem = new JMenuItem();
        guideItem.setFont(new Font("Arial", 1, 15));
        guideItem.setIcon(new ImageIcon(SettingMenu.class.getResource("/Pictures/help-icon.png")));
        guideItem.setBackground(new Color(0, 0, 84));
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
        infoItem = new JMenuItem();
        infoItem.setFont(new Font("Arial", 1, 15));
        infoItem.setIcon(new ImageIcon(SettingMenu.class.getResource("/Pictures/info-icon.png")));
        infoItem.setBackground(new Color(0, 0, 126));
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

    private void changeLanguage() {
        languageMenu = new JMenu();
        languageMenu.setFont(new Font("Arial", 1, 15));
        languageMenu.setIcon(new ImageIcon(SettingMenu.class.getResource("/Pictures/language-icon.png")));
        languageMenu.setOpaque(true);
        languageMenu.setBackground(new Color(0, 0, 168));
        languageMenu.setForeground(Color.WHITE);
        setEnglish();
        setVietnamese();
        add(languageMenu);
    }

    private void setEnglish() {
        englishItem = new JMenuItem("English");
        englishItem.setFont(new Font("Arial", 1, 15));
        englishItem.setBackground(new Color(102, 0, 102));
        englishItem.setForeground(Color.WHITE);
        englishItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Language.setEnglish();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Database/Language.txt"))) {
                    bw.write("english");
                } catch (IOException ex) {}
            }
        });
        languageMenu.add(englishItem);
    }

    private void setVietnamese() {
        vietnameseItem = new JMenuItem("Tiếng Việt");
        vietnameseItem.setFont(new Font("Arial", 1, 15));
        vietnameseItem.setBackground(new Color(102, 0, 153));
        vietnameseItem.setForeground(Color.WHITE);
        vietnameseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Language.setVietnamese();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Database/Language.txt"))) {
                    bw.write("vietnamese");
                } catch (IOException ex) {}
            }
        });
        languageMenu.add(vietnameseItem);
    }
    
    private void setOtherMenu() {
        otherMenu = new JMenu();
        otherMenu.setFont(new Font("Arial", 1, 15));
        otherMenu.setIcon(new ImageIcon(SettingMenu.class.getResource("/Pictures/other_tools.png")));
        otherMenu.setOpaque(true);
        otherMenu.setBackground(new Color(0, 0, 255));
        otherMenu.setForeground(Color.WHITE);
        accessDrive();
        dataStructure();
        add(otherMenu);
    }

    private void accessDrive() {
        driveItem = new JMenuItem("Drive");
        driveItem.setFont(new Font("Arial", 1, 15));
        driveItem.setIcon(new ImageIcon(SettingMenu.class.getResource("/Pictures/drive-icon.png")));
        driveItem.setBackground(new Color(102, 0, 102));
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
        otherMenu.add(driveItem);
    }
    
        private void dataStructure() {
        dataStructureItem = new JMenuItem();
        dataStructureItem.setFont(new Font("Arial", 1, 15));
        dataStructureItem.setIcon(new ImageIcon(SettingMenu.class.getResource("/Pictures/data_icon.png")));
        dataStructureItem.setBackground(new Color(102, 0, 153));
        dataStructureItem.setForeground(Color.WHITE);
        dataStructureItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(new File("src/Database/visualization.jar"));
                } catch (IOException e) {}
            }
        });
        otherMenu.add(dataStructureItem);
    }

    public SettingMenu() {
        changeInfo();
        setGuide();
        getInformation();
        changeLanguage();
        setOtherMenu();

        if ("english".equals(MainFrame.getLanguage())) {
            infoMenu.setText("Change Info");
            avatarItem.setText("Change Avatar");
            nameItem.setText("Change Name");
            guideItem.setText("Guide");
            infoItem.setText("App's Information");
            languageMenu.setText("Language");
            otherMenu.setText("Other tools");
            dataStructureItem.setText("Data Structure");
        } else {
            infoMenu.setText("Thay đổi thông tin");
            avatarItem.setText("Thay ảnh đại diện");
            nameItem.setText("Thay đổi tên");
            guideItem.setText("Hướng dẫn");
            infoItem.setText("Thông tin ứng dụng");
            languageMenu.setText("Ngôn ngữ");
            otherMenu.setText("Công cụ khác");
            dataStructureItem.setText("Cấu trúc dữ liệu");
        }
    }
}