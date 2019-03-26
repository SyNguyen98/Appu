package APPU;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

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

    public SettingFrame() {      
        setTitle("Setting");
        setSize(250, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        try {
            setIconImage(ImageIO.read(SettingFrame.class.getResource("/Pictures/Icon.jpg")));
        } catch (IOException ex) {}
    
        setChangeAvaButton();
    }
    
}
