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
import javax.swing.Timer;

public class GuideFrame extends JFrame {

    Timer timer1, timer2, timer3, timer4, timer5, timer6, timer7, timer8;
    private JLabel title_g1, title_g2, title_g3, guide_1, guide_2, guide_3;
    private JLabel step1_1, step1_2, step1_3, endGuide_1, nextGuide;
    private JLabel step2_1, step2_2, step2_3, nextGuide2;
    private JLabel step3_1, step3_2, nextGuide3;
    private JLabel startTutorial, Instruction_logo, Round_Frame;
    private JButton exitButton;

    private void setExitButton() {
        exitButton = new CircleButton();
        try {
            Image image = ImageIO.read(new File("src/Pictures/Exit.png"));
            exitButton.setIcon(new ImageIcon(image));
        } catch (IOException ex) {
        }
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

        title_g1 = new JLabel();
        title_g1.setIcon(new ImageIcon("src/Pictures/Title_guide1.png"));
        title_g1.setBounds(7, 5, 177, 30);
        add(title_g1);
        title_g1.setVisible(false);

        title_g2 = new JLabel();
        title_g2.setIcon(new ImageIcon("src/Pictures/Title_guide2.png"));
        title_g2.setBounds(7, 5, 271, 30);
        add(title_g2);
        title_g2.setVisible(false);

        title_g3 = new JLabel();
        title_g3.setIcon(new ImageIcon("src/Pictures/Title_guide3.png"));
        title_g3.setBounds(7, 5, 271, 30);
        add(title_g3);
        title_g3.setVisible(false);

        endGuide_1 = new JLabel();
        endGuide_1.setIcon(new ImageIcon("src/Pictures/ending_guide1.png"));
        endGuide_1.setBounds(75, 20, 500, 378);
        add(endGuide_1);
        endGuide_1.setVisible(false);

        Round_Frame = new JLabel();
        Round_Frame.setIcon(new ImageIcon("src/Pictures/Round_frame.png"));
        Round_Frame.setBounds(75, 20, 500, 378);
        add(Round_Frame);
        Round_Frame.setVisible(false);

        nextGuide = new JLabel();
        nextGuide.setIcon(new ImageIcon("src/Pictures/next_guide.png"));
        nextGuide.setBounds(580, 480, 55, 55);
        add(nextGuide);
        nextGuide.setVisible(false);

        nextGuide2 = new JLabel();
        nextGuide2.setIcon(new ImageIcon("src/Pictures/next_guide.png"));
        nextGuide2.setBounds(580, 480, 55, 55);
        add(nextGuide2);
        nextGuide2.setVisible(false);

        nextGuide3 = new JLabel();
        nextGuide3.setIcon(new ImageIcon("src/Pictures/next_guide.png"));
        nextGuide3.setBounds(580, 480, 55, 55);
        add(nextGuide3);
        nextGuide3.setVisible(false);

        //Start Guide 1:
        startTutorial.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startTutorial.setVisible(false);
                Instruction_logo.setVisible(false);

                Round_Frame.setVisible(true);
                title_g1.setVisible(true);

                setGuide_1();
                timer3 = new Timer(7000, ae -> {
                    guide_1.setVisible(false);
                    Round_Frame.setVisible(false);
                    endGuide_1.setVisible(true);
                    nextGuide.setVisible(true);
                    timer3.stop();
                });
                
                timer2 = new Timer(7000, ae -> {
                    step1_3.setVisible(true);
                    timer3.start();
                    timer2.stop();
                });
               
                timer1 = new Timer(3000, ae -> {
                    step1_2.setVisible(true);
                    timer2.start();
                    timer1.stop();
                });
                timer1.start();
            }
        });

        //Start guide 2:
        nextGuide.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {              
                nextGuide.setVisible(false);
                title_g1.setVisible(false);
                endGuide_1.setVisible(false);
                step1_1.setVisible(false);
                step1_2.setVisible(false);
                step1_3.setVisible(false);

                Round_Frame.setVisible(true);
                title_g2.setVisible(true);

                setGuide_2();
                timer6 = new Timer(6000, ae -> {
                    guide_2.setVisible(false);
                    Round_Frame.setVisible(false);
                    endGuide_1.setVisible(true);
                    nextGuide2.setVisible(true);
                    timer6.stop();
                });

                timer5 = new Timer(10000, ae -> {
                    step2_1.setVisible(false);
                    step2_2.setVisible(false);
                    step2_3.setVisible(true);
                    timer6.start();
                    timer5.stop();
                });

                timer4 = new Timer(6000, ae -> {
                    step2_2.setVisible(true);
                    timer5.start();
                    timer4.stop();
                });
                timer4.start();
                //
            }
        });

        //Start guide 3:
        nextGuide2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nextGuide2.setVisible(false);
                title_g2.setVisible(false);
                endGuide_1.setVisible(false);
                step2_1.setVisible(false);
                step2_2.setVisible(false);
                step2_3.setVisible(false);

                Round_Frame.setVisible(true);
                title_g3.setVisible(true);

                setGuide_3();
                timer8 = new Timer(14000, ae -> {
                    guide_3.setVisible(false);
                    Round_Frame.setVisible(false);
                    endGuide_1.setVisible(true);
                    nextGuide3.setVisible(true);
                    timer8.stop();
                });

                timer7 = new Timer(8000, ae -> {
                    step3_2.setVisible(true);
                    step3_1.setVisible(false);
                    timer8.start();
                    timer7.stop();
                });
                timer7.start();
            }
        });

        /*      endGuide_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                guide_1.setVisible(false);
                endGuide_1.setVisible(false);
                step1_2.setVisible(false);
                step1_3.setVisible(false);
                
                Round_Frame.setVisible(true);
                guide_1.setVisible(true);
                
                Timer timer6 = new Timer(7000, ae -> {
                    guide_1.setVisible(false);
                    Round_Frame.setVisible(false);
                    endGuide_1.setVisible(true);
                    nextGuide.setVisible(true);
                });
                
                Timer timer5 = new Timer(7000, ae -> {
                    step1_3.setVisible(true);
                    timer6.start();
                });
               
                Timer timer4 = new Timer(3000, ae -> {
                    step1_2.setVisible(true);
                    timer5.start();
                });
                timer4.start();
            }
        });     */
 /*    endGuide_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                endGuide_1.setVisible(false);
                Round_Frame.setVisible(true);
                guide_1.setVisible(true);
                
                Timer timer = new Timer(17000, ae -> {
                    guide_1.setVisible(false);
                    Round_Frame.setVisible(false);
                    endGuide_1.setVisible(true);
                });
                timer.start();
            }
        }); */
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

    private void setGuide_2() {
        guide_2 = new JLabel();
        guide_2.setIcon(new ImageIcon("src/Pictures/Guide 2. Using with keywords.gif"));
        guide_2.setBounds(75, 20, 500, 378);

        step2_1 = new JLabel();
        step2_1.setIcon(new ImageIcon("src/Pictures/Step 2.1.png"));
        step2_1.setBounds(110, 390, 430, 67);

        step2_2 = new JLabel();
        step2_2.setIcon(new ImageIcon("src/Pictures/Step 2.2.png"));
        step2_2.setBounds(110, 450, 430, 103);
        step2_2.setVisible(false);

        step2_3 = new JLabel();
        step2_3.setIcon(new ImageIcon("src/Pictures/Step 1.3.png"));
        step2_3.setBounds(140, 450, 363, 40);
        step2_3.setVisible(false);

        add(guide_2);
        add(step2_1);
        add(step2_2);
        add(step2_3);
    }

    private void setGuide_3() {
        guide_3 = new JLabel();
        guide_3.setIcon(new ImageIcon("src/Pictures/Guide 3. Open PC app.gif"));
        guide_3.setBounds(75, 20, 500, 378);

        step3_1 = new JLabel();
        step3_1.setIcon(new ImageIcon("src/Pictures/Step 3.1.png"));
        step3_1.setBounds(110, 390, 450, 121);

        step3_2 = new JLabel();
        step3_2.setIcon(new ImageIcon("src/Pictures/Step 3.2.png"));
        step3_2.setBounds(110, 460, 365, 40);
        step3_2.setVisible(false);

        add(guide_3);
        add(step3_1);
        add(step3_2);
    }

    public GuideFrame() {
        setLayout(null);
        setSize(650, 550);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/Pictures/Guide_ground.jpg")))));
        } catch (IOException ex) {
        }
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        try {
            setIconImage(ImageIO.read(new File("src/Pictures/Icon.png")));
        } catch (IOException ex) {
        }

        setExitButton();
        setStartTutorial();
    }
}
