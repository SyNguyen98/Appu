package APPU;

import Command.ChangeAvatar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class SettingMenu extends JPopupMenu {
    private static JMenuItem avatarItem, nameItem;
    
    private static void changeAvatar() {
        avatarItem = new JMenuItem("Change Avatar");
        avatarItem.setFont(new Font("Arial", 1, 15));
        avatarItem.setIcon(new ImageIcon("C:\\Users\\PC\\Downloads\\avatar-icon.png"));
        avatarItem.setBackground(Color.CYAN);
        avatarItem.setBounds(0, 0, 100, 50);
        avatarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ChangeAvatar.setAvatar();
            }
        });
    }
    
    private static void changeName() {
        nameItem = new JMenuItem("Change Name");
        nameItem.setFont(new Font("Arial", 1, 15));
        nameItem.setIcon(new ImageIcon("C:\\Users\\PC\\Downloads\\name-icon.png"));
        nameItem.setBackground(Color.ORANGE);
        nameItem.setBounds(0, 50, 100, 50);
        nameItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TitlePanel.nameLabel.setText(JOptionPane.showInputDialog(null));
            }
        });
    }
    
    public SettingMenu() {
        changeAvatar();
        changeName();

        add(avatarItem);
        add(nameItem);
        
    }
}
