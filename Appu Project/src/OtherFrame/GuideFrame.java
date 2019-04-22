package OtherFrame;

import MainFrame.TitlePanel;
import Shape.CircleButton;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuideFrame extends JFrame {

    private JLabel guide;
    private JLabel startTutorial, startImage;
    private JButton exitButton;
    
    private void setExitButton() {
        exitButton = new CircleButton();
        try {
            Image image = ImageIO.read(TitlePanel.class.getResource("/Pictures/Exit.png"));
            exitButton.setIcon(new ImageIcon(image));
        } catch (IOException ex) {}
        exitButton.setBounds(450, 15, 30, 30);
        exitButton.setToolTipText("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
    }

    private void setStartTutorial() {
        startTutorial = new JLabel();
        startTutorial.setIcon(new ImageIcon("src/Pictures/1.png"));
        startTutorial.setBounds(10, 10, 300, 80);
        add(startTutorial);

        startImage = new JLabel();
        startImage.setIcon(new ImageIcon("src/Pictures/2.png"));
        startImage.setBounds(100, 80, 340, 340);
        add(startImage);

        startTutorial.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startTutorial.setVisible(false);
                startImage.setVisible(false);
                setGuide();
                guide.setVisible(true);
            }
        });
    }
    
    private void setGuide() {
        guide = new JLabel();
        guide.setIcon(new ImageIcon("src/Pictures/1.gif"));
        guide.setBounds(-5, 50, 500, 400);
        add(guide);
    }

    public GuideFrame() {
        setTitle("Guide");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        try {
            setIconImage(ImageIO.read(TitlePanel.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}
        
        setExitButton();
        setStartTutorial();
    }
}
