package OtherFrame;

import MainFrame.TitlePanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GuideFrame extends JFrame {
<<<<<<< HEAD
    private JLabel GUIDE = new JLabel();
    private JLabel StartTurial = new JLabel();
    private JLabel StartImg = new JLabel();
 //   private static final JButton StarTurial = new JButton();
=======
>>>>>>> d743ceeaef39a635ba55946d575c96c2423bee63

    public GuideFrame() {  
        setResizable(false);
        setTitle("Guide");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        try {
            setIconImage(ImageIO.read(TitlePanel.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}
<<<<<<< HEAD
        StartTurial.setIcon(new ImageIcon("src/Pictures/1.png"));
        StartTurial.setBounds(10, 10, 300, 80);
        add(StartTurial);
        StartImg.setIcon(new ImageIcon("src/Pictures/2.png"));
        StartImg.setBounds(100, 80, 340, 340);
        add(StartImg);
        StartTurial.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StartTurial.setVisible(false);
                StartImg.setVisible(false);
                GUIDE.setIcon(new ImageIcon("src/Pictures/1.gif"));
                GUIDE.setBounds(10, 30, 500, 400);
                add(GUIDE);
                GUIDE.setVisible(true);
            } 
        });
        
        
  //      GUIDE.setVisible(false);
=======
>>>>>>> d743ceeaef39a635ba55946d575c96c2423bee63
    }
}
