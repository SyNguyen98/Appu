package APPU;

import Command.Performance;
import Sound.Theme;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame  {
    public static final JFrame frame = new JFrame("iSekai");
    private static final TitlePanel titlePanel = new TitlePanel();
    private static final MainPanel mainPanel = new MainPanel();
    private static final JLabel introLabel = new JLabel();
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {}
<<<<<<< HEAD
        Theme.play("src/Sound/EndGame.wav");
=======
        Theme.play("src/Sound/winxp.wav");
>>>>>>> 8675a7cba1cbc66a32e7570134eacdc9f0d83da8
        
        introLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/Pictures/Intro.gif")));
        introLabel.setBounds(0, 0, 800, 640);
        introLabel.setVisible(true);
        try {
            frame.setIconImage(ImageIO.read(TitlePanel.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}
        
        frame.setSize(480, 640);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(frame);
        frame.setVisible(true);
        frame.add(introLabel);
        frame.add(mainPanel);
        frame.add(titlePanel);
        mainPanel.setVisible(false);
        titlePanel.setVisible(false);            
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException ex) {}
        introLabel.setVisible(false);
        mainPanel.setVisible(true);
        titlePanel.setVisible(true);
        
        Performance.Do(); 
    }
}