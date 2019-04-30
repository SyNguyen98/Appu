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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuideFrame extends JFrame {

    private JLabel guide_1, guide_2, guide_3;
    private JLabel step1_1, step1_2, step1_3;
    private JLabel startTutorial, Instruction_logo, Round_Frame;
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
        Round_Frame = new JLabel();
        Round_Frame.setIcon(new ImageIcon("src/Pictures/Test_round_frame.png"));
        Round_Frame.setBounds(75, 20, 500, 378);
        add(Round_Frame);
        Round_Frame.setVisible(false);
        
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
                Round_Frame.setVisible(true);
                setGuide_1();
                try {
                    TimeUnit.MILLISECONDS.sleep(2500);
                    } catch (InterruptedException ex) {}
                // delay 2500 miliseconds.
                step1_2.setVisible(true);
                // delay 5000 miliseconds.
                step1_3.setVisible(true);
            }
        });
    }
    
    private void setGuide_1() {
        guide_1 = new JLabel();
        guide_1.setIcon(new ImageIcon("src/Pictures/Guide 1. Normal Using.gif"));
        guide_1.setBounds(75, 20, 500, 378);
        
        step1_1 = new JLabel();
        step1_1.setIcon(new ImageIcon("src/Pictures/Step 1.1.png"));
        step1_1.setBounds(110, 390, 400, 38);
        
        step1_2 = new JLabel();
        step1_2.setIcon(new ImageIcon("src/Pictures/Step 1.2.png"));
        step1_2.setBounds(108, 420, 450, 74);
        step1_2.setVisible(false);
        
        step1_3 = new JLabel();
        step1_3.setIcon(new ImageIcon("src/Pictures/Step 1.3.png"));
        step1_3.setBounds(140, 490, 363, 40);
        step1_3.setVisible(false);
        
        add(guide_1);
        add(step1_1);
        add(step1_2);
        add(step1_3);
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
    
