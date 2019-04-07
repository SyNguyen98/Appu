package MainFrame;

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
    
    private static void setIntro() {
        Theme.play("src/Sound/Intro.wav");
        introLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/Pictures/Intro.gif")));
        introLabel.setBounds(0, 0, 800, 640);
        frame.add(introLabel); 
        
    }
    
    public static void main(String[] args) {  
        setIntro();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {}     
       
        try {
            frame.setIconImage(ImageIO.read(TitlePanel.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}   
        frame.setSize(480, 640);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(frame);
        frame.setVisible(true);       
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException ex) {}
        introLabel.setVisible(false);
        frame.add(mainPanel);
        frame.add(titlePanel);
        
        Performance.Do(); 
    }
}