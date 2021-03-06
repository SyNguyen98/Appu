package MainFrame;

import Performance.Performance;
import Setting.FrameDrag;
import Sound.Sound;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame {

    public static final JFrame frame = new JFrame();
    private static final FrameDrag frameDrag = new FrameDrag(frame);
    private static final TitlePanel titlePanel = new TitlePanel();
    private static final MainPanel mainPanel = new MainPanel();
    private static final InputPanel inputPanel = new InputPanel();
    private static final JLabel introLabel = new JLabel();
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private static void setIntro() {
//        Sound.play("src/Sound/Endgame.wav");
        introLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/Pictures/Intro.gif")));
        introLabel.setBounds(-30, 0, 600, 640);
        frame.add(introLabel);
    }
    
    public static String getLanguage() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(MainFrame.class.getResourceAsStream("/Database/Language.txt")))) {
            String language = br.readLine();
            return language;
        } catch (IOException ex) {}
        return null;
    }

    public static void main(String[] args) {
        setIntro();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {}

        try {
            frame.setIconImage(ImageIO.read(MainFrame.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}
        frame.setSize(480, 640);
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 50, 50));
        frame.setLocation((int) screenSize.getWidth() - 480, (int) screenSize.getHeight()/2 - 320);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.addMouseListener(frameDrag);
        frame.addMouseMotionListener(frameDrag);
        
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException ex) {}
        
        introLabel.setVisible(false);
        frame.add(inputPanel);
        frame.add(titlePanel);
        frame.add(mainPanel);
            
        Performance.Do();
    }
}
