package APPU;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GuideFrame extends JFrame {

    public GuideFrame() {
        setTitle("Guide");
        setSize(500, 500);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            setIconImage(ImageIO.read(TitlePanel.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}
    }
}
