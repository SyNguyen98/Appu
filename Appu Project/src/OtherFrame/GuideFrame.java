package OtherFrame;

import MainFrame.TitlePanel;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuideFrame extends JFrame {
    private static final JLabel GUIDE = new JLabel();

    public GuideFrame() {
        setTitle("Guide");
        setSize(540, 550);
        setLocationRelativeTo(null);
        try {
            setIconImage(ImageIO.read(TitlePanel.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}
        GUIDE.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/1.gif")));
        GUIDE.setBounds(0, 0, 50, 50);
        add(GUIDE);
  //      GUIDE.setVisible(false);
    }
}
