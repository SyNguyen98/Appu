package OtherFrame;

import Shape.CircleButton;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuideFrame extends JFrame {

    private JLabel guide_1, guide_2, guide_3;
    private JLabel startTutorial, Instruction_logo;
    private JButton exitButton;
    
    private void setExitButton() {
        exitButton = new CircleButton();
        try {
            Image image = ImageIO.read(new File("src/Pictures/Exit.png"));
            exitButton.setIcon(new ImageIcon(image));
        } catch (IOException ex) {}
        
        exitButton.setBounds(600, 15, 30, 30);
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
        startTutorial.setIcon(new ImageIcon("src/Pictures/Start_tutorial.png"));
        startTutorial.setBounds(20, 20, 250, 70);
        add(startTutorial);

        Instruction_logo = new JLabel();
        Instruction_logo.setIcon(new ImageIcon("src/Pictures/Instruction_logo.png"));
        Instruction_logo.setBounds(100, 50, 450, 450);
        add(Instruction_logo);

        startTutorial.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startTutorial.setVisible(false);
                Instruction_logo.setVisible(false);
                setGuide();
                guide_1.setVisible(true);
            }
        });
    }
    
    private void setGuide() {
        guide_1 = new JLabel();
        guide_1.setIcon(new ImageIcon("src/Pictures/Guide 1. Normal Using.gif"));
        guide_1.setBounds(75, 30, 500, 378);
        add(guide_1);
    }

    public GuideFrame() {
        setLayout(null);
        setSize(650, 550);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/Pictures/Guide_ground.jpg")))));
        } catch (IOException ex) {}
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        try {
            setIconImage(ImageIO.read(new File("src/Pictures/Icon.png")));
        } catch (IOException ex) {}
        
        setExitButton();
        setStartTutorial();
    }
}
