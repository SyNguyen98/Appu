package Command;

import APPU.MainFrame;
import APPU.TitlePanel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class ChangeAvatar {
    private static final JFileChooser chooser = new JFileChooser("iSekai");
    
    private static String getImagePath() {
        int returnVal = chooser.showOpenDialog(MainFrame.frame);
        if(returnVal == JFileChooser.APPROVE_OPTION) {        
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    
    public static void setAvatar() {
        BufferedImage img = null;
        try {
                img = ImageIO.read(new File(getImagePath()));
        } catch (IOException e) {}
        Image dimg = img.getScaledInstance(TitlePanel.imageLabel.getWidth(), TitlePanel.imageLabel.getHeight(), Image.SCALE_SMOOTH);
    }
}
