package Setting;

import MainFrame.MainFrame;
import MainFrame.TitlePanel;
import Shape.CircleLabel;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ChangeInfo {

    private static final JFileChooser chooser = new JFileChooser("iSekai");

    private static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    private static String getImagePath() {
        int returnVal = chooser.showOpenDialog(MainFrame.frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    public static void setAvatar() {
        try {
            BufferedImage img = ImageIO.read(new File(getImagePath()));
            ImageIO.write(img, "jpg", new File("src/Pictures/Avatar.jpg"));
            TitlePanel.imageLabel.setIcon(CircleLabel.setImageLabel(resize(img, 50, 50)));
        } catch (IOException e) {
        }
    }

    public static void setName() {
        String name = JOptionPane.showInputDialog(null, "Input name :", "Change Name", JOptionPane.INFORMATION_MESSAGE);
        TitlePanel.nameLabel.setText(name);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Database/Name.txt"))) {
            bw.write(name);
        } catch (IOException ex) {}
    }
}
