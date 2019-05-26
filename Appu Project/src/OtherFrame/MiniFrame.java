package OtherFrame;

import MainFrame.MainFrame;
import Setting.FrameDrag;
import Shape.CircleLabel;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniFrame extends JFrame{
    private final FrameDrag frameDrag = new FrameDrag(this) {
        @Override
        public void mouseClicked(MouseEvent e) {
            MainFrame.frame.setVisible(true);
            setVisible(false);
        } 
    };
    
    private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    } 
    
    private void setAvatarLabel() {
        JLabel imageLabel = new JLabel();
        BufferedImage image = null;
        try {                      
            image = ImageIO.read(MiniFrame.class.getResource("/Pictures/Avatar.jpg"));
            imageLabel.setIcon(CircleLabel.setImageLabel(resize(image, 70, 70)));
        } catch (IOException ex) {}
        imageLabel.setBounds(0, 0, 70, 70);
        add(imageLabel);
    }

    public MiniFrame() {
        try {
            setIconImage(ImageIO.read(MiniFrame.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}
        setAvatarLabel();
        setSize(70, 70);
        setLayout(null);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setShape(new Ellipse2D.Double(0, 0, getWidth(), getHeight()));
        addMouseListener(frameDrag);
        addMouseMotionListener(frameDrag);
    }
}
