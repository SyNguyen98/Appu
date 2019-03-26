package APPU;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame  {
    public static final JFrame frame = new JFrame("APPU");
    private static final TitlePanel titlePanel = new TitlePanel();
    private static final MainPanel mainPanel = new MainPanel();
    private static final JLabel introLabel = new JLabel();
    
    public static void main(String[] args) {
        introLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/Pictures/FINAL intro.gif")));
        introLabel.setBounds(-65, 0, 800, 640);
        introLabel.setVisible(true);
        try {
            frame.setIconImage(ImageIO.read(TitlePanel.class.getResource("/Pictures/Icon.jpg")));
        } catch (IOException ex) {}
        frame.setSize(480, 640);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(frame);
        frame.setVisible(true);
        frame.add(introLabel);
        frame.add(mainPanel);
        frame.add(titlePanel);
        Command.Performance.Do();       
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {}
        introLabel.setVisible(false);
        
    }
}