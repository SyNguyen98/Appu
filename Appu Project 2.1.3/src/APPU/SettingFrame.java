package APPU;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SettingFrame extends JFrame {
    private static JButton changeAvaButton, changeNameButton;
    
    private void setChangeAvaButton() {
        changeAvaButton = new JButton("Change Avatar");
        changeAvaButton.setBounds(0, 0, 250, 60);
        add(changeAvaButton);
        changeAvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Command.ChangeAvatar.setAvatar();
            }
        });
    }
    
    private void setChangeNameButton() {
        changeNameButton = new JButton("Change Name");
        changeNameButton.setBounds(0, 70, 250, 60);
        add(changeNameButton);
        changeNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TitlePanel.nameLabel.setText(JOptionPane.showInputDialog(null));
            }
        });
    }

    public SettingFrame() {      
        setTitle("Setting");
        setSize(250, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        try {
            setIconImage(ImageIO.read(SettingFrame.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}
    
        setChangeAvaButton();
        setChangeNameButton();
    }
    
}
