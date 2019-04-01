package APPU;

import Command.ChangeAvatar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class SettingMenu extends JPopupMenu {
    private static JMenuItem avatarItem, nameItem, helpItem;
    private static final JFrame guideFrame = new GuideFrame();
    
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
                TitlePanel.nameLabel.setText(JOptionPane.showInputDialog(null));
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
    
    public SettingMenu() {
        changeAvatar();
        add(avatarItem);
        changeName();
        add(nameItem);
        help();
        add(helpItem);
    }
}
