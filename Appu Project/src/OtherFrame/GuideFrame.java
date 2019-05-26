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

    Timer timer1, timer2, timer3, timer4, timer5, timer6, timer7, timer8, timerback1, timerback2, timerback3;
    Timer timereplay, timereplay2, timereplay3;
    private JLabel title_g1, title_g2, title_g3, guide_1, guide_2, guide_3;
    private JLabel step1_1, step1_2, step1_3, replayGuide_1, nextGuide;
    private JLabel step2_1, step2_2, step2_3, replayGuide_2, nextGuide2;
    private JLabel step3_1, step3_2, replayGuide_3, doneGuide;
    private JLabel backtoGuide1, backtoGuide2, nextafterGuide1, nextafterGuide2;
    private JLabel startTutorial, Instruction_logo, Round_Frame;
    private JButton exitButton;

    private void setExitButton() {
        exitButton = new CircleButton();
        try {
            Image image = ImageIO.read(GuideFrame.class.getResource("/Pictures/Exit.png"));
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
        startTutorial.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Start_tutorial.png")));
        startTutorial.setBounds(20, 20, 250, 70);
        add(startTutorial);

        Instruction_logo = new JLabel();
        Instruction_logo.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Instruction_logo.png")));
        Instruction_logo.setBounds(100, 50, 450, 450);
        add(Instruction_logo);

        title_g1 = new JLabel();
        title_g1.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Title_guide1.png")));
        title_g1.setBounds(7, 5, 177, 30);
        add(title_g1);
        title_g1.setVisible(false);

        title_g2 = new JLabel();
        title_g2.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Title_guide2.png")));
        title_g2.setBounds(7, 5, 271, 30);
        add(title_g2);
        title_g2.setVisible(false);

        title_g3 = new JLabel();
        title_g3.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Title_guide3.png")));
        title_g3.setBounds(7, 5, 271, 30);
        add(title_g3);
        title_g3.setVisible(false);

        replayGuide_1 = new JLabel();
        replayGuide_1.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/replay_guide.png")));
        replayGuide_1.setBounds(75, 20, 500, 378);
        add(replayGuide_1);
        replayGuide_1.setVisible(false);
        
        replayGuide_2 = new JLabel();
        replayGuide_2.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/replay_guide.png")));
        replayGuide_2.setBounds(75, 20, 500, 378);
        add(replayGuide_2);
        replayGuide_2.setVisible(false);
        
        replayGuide_3 = new JLabel();
        replayGuide_3.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/replay_guide.png")));
        replayGuide_3.setBounds(75, 20, 500, 378);
        add(replayGuide_3);
        replayGuide_3.setVisible(false);

        Round_Frame = new JLabel();
        Round_Frame.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Round_frame.png")));
        Round_Frame.setBounds(75, 20, 500, 378);
        add(Round_Frame);
        Round_Frame.setVisible(false);

        nextGuide = new JLabel();
        nextGuide.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/next_guide.png")));
        nextGuide.setBounds(580, 480, 55, 55);
        add(nextGuide);
        nextGuide.setVisible(false);

        nextGuide2 = new JLabel();
        nextGuide2.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/next_guide.png")));
        nextGuide2.setBounds(580, 480, 55, 55);
        add(nextGuide2);
        nextGuide2.setVisible(false);

        nextafterGuide1 = new JLabel();
        nextafterGuide1.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/next_guide.png")));
        nextafterGuide1.setBounds(580, 480, 55, 55);
        add(nextafterGuide1);
        nextafterGuide1.setVisible(false);
        
        nextafterGuide2 = new JLabel();
        nextafterGuide2.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/next_guide.png")));
        nextafterGuide2.setBounds(580, 480, 55, 55);
        add(nextafterGuide2);
        nextafterGuide2.setVisible(false);
        
        doneGuide = new JLabel();
        doneGuide.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/done_guide.png")));
        doneGuide.setBounds(580, 480, 55, 55);
        add(doneGuide);
        doneGuide.setVisible(false);
        
        backtoGuide1 = new JLabel();
        backtoGuide1.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/back_guide.png")));
        backtoGuide1.setBounds(15, 480, 55, 55);
        add(backtoGuide1);
        backtoGuide1.setVisible(false);
        
        backtoGuide2 = new JLabel();
        backtoGuide2.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/back_guide.png")));
        backtoGuide2.setBounds(15, 480, 55, 55);
        add(backtoGuide2);
        backtoGuide2.setVisible(false);
        
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
                    replayGuide_1.setVisible(true);
                    timer3.stop();
                });
                
                timer2 = new Timer(7000, ae -> {
                    nextGuide.setVisible(true);
                    step1_3.setVisible(true);
                    timer3.start();
                    timer3.restart();
                    timer2.stop();
                });
               
                timer1 = new Timer(3000, ae -> {
                    step1_2.setVisible(true);
                    timer2.start();
                    timer2.restart();
                    timer1.stop();
                });
                timer1.start();
                timer1.restart();
            }
        });

        //Start guide 2:
        nextGuide.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timer3.stop();
                guide_1.setVisible(false);
                nextGuide.setVisible(false);
                title_g1.setVisible(false);
                replayGuide_1.setVisible(false);
                step1_1.setVisible(false);
                step1_2.setVisible(false);
                step1_3.setVisible(false);

                backtoGuide1.setVisible(true);
                Round_Frame.setVisible(true);
                title_g2.setVisible(true);

                setGuide_2();
                timer6 = new Timer(6000, ae -> {
                    guide_2.setVisible(false);
                    Round_Frame.setVisible(false);
                    replayGuide_2.setVisible(true);
                    timer6.stop();
                });

                timer5 = new Timer(10000, ae -> {
                    nextGuide2.setVisible(true);
                    step2_1.setVisible(false);
                    step2_2.setVisible(false);
                    step2_3.setVisible(true);
                    timer6.start();
                    timer6.restart();
                    timer5.stop();
                });

                timer4 = new Timer(6000, ae -> {
                    step2_2.setVisible(true);
                    timer5.start();
                    timer5.restart();
                    timer4.stop();
                });
                timer4.start();
                timer4.restart();
                //
            }
        });

        //Back to guide 1 from guide 2:
        backtoGuide1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timer4.stop();
                timer5.stop();
                timer6.stop();
                backtoGuide1.setVisible(false);
                guide_2.setVisible(false);
                title_g2.setVisible(false);
                replayGuide_2.setVisible(false);
                step2_1.setVisible(false);
                step2_2.setVisible(false);
                step2_3.setVisible(false);

                Round_Frame.setVisible(true);
                guide_1.setVisible(true);
                title_g1.setVisible(true);
                step1_1.setVisible(true);
                step1_2.setVisible(true);
                step1_3.setVisible(true);
                nextafterGuide1.setVisible(true);

                timerback1 = new Timer(17000, ae -> {
                    guide_2.setVisible(false);
                    Round_Frame.setVisible(false);
                    replayGuide_1.setVisible(true);
                    timerback1.stop();
                });
                timerback1.start();
                timerback1.restart();
                //
            }
        });
        
        //Next after back GUIDE 2 <1->2>:
        nextafterGuide1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timerback1.stop();
                nextafterGuide1.setVisible(false);
                guide_1.setVisible(false);
                title_g1.setVisible(false);
                replayGuide_1.setVisible(false);
                step1_1.setVisible(false);
                step1_2.setVisible(false);
                step1_3.setVisible(false);

                Round_Frame.setVisible(true);
                guide_2.setVisible(true);
                title_g2.setVisible(true);
                step2_1.setVisible(true);
                step2_2.setVisible(true);
                nextafterGuide2.setVisible(true);
                backtoGuide1.setVisible(true);

                timerback2 = new Timer(22000, ae -> {
                    guide_2.setVisible(false);
                    Round_Frame.setVisible(false);
                    replayGuide_2.setVisible(true);
                    timerback2.stop();
                });
                timerback2.start();
                timerback2.restart();
                //
            }
        });
        
        //Start guide 3:
        nextGuide2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timer6.stop();
                backtoGuide1.setVisible(false);
                guide_2.setVisible(false);
                nextGuide2.setVisible(false);
                title_g2.setVisible(false);
                replayGuide_2.setVisible(false);
                step2_1.setVisible(false);
                step2_2.setVisible(false);
                step2_3.setVisible(false);

                backtoGuide2.setVisible(true);
                Round_Frame.setVisible(true);
                title_g3.setVisible(true);

                setGuide_3();
                timer8 = new Timer(5000, ae -> {
                    guide_3.setVisible(false);
                    Round_Frame.setVisible(false);
                    replayGuide_3.setVisible(true);
                    doneGuide.setVisible(true);
                    timer8.stop();
                });

                timer7 = new Timer(11000, ae -> {
                    step3_2.setVisible(true);
                    step3_1.setVisible(false);
                    timer8.start();
                    timer8.restart();
                    timer7.stop();
                });
                timer7.start();
                timer7.restart();
            }
        });
        
        //Back to guide 2 from guide 3:
        backtoGuide2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timer8.stop();
                timer7.stop();
                guide_3.setVisible(false);
                title_g3.setVisible(false);
                replayGuide_3.setVisible(false);
                step3_1.setVisible(false);
                step3_2.setVisible(false);
                backtoGuide2.setVisible(false);

                Round_Frame.setVisible(true);
                guide_2.setVisible(true);
                title_g2.setVisible(true);
                step2_1.setVisible(true);
                step2_2.setVisible(true);
                nextafterGuide2.setVisible(true);
                backtoGuide1.setVisible(true);

                timerback2 = new Timer(22000, ae -> {
                    guide_2.setVisible(false);
                    Round_Frame.setVisible(false);
                    replayGuide_2.setVisible(true);
                    timerback2.stop();
                });
                timerback2.start();
                timerback2.restart();
                //
            }
        });
        
        //Next after back GUIDE 3 <2->3>:
        nextafterGuide2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timerback2.stop();
                setGuide_3();
                nextafterGuide2.setVisible(false);
                backtoGuide1.setVisible(false);
                guide_2.setVisible(false);
                nextGuide2.setVisible(false);
                title_g2.setVisible(false);
                replayGuide_2.setVisible(false);
                step2_1.setVisible(false);
                step2_2.setVisible(false);
                step2_3.setVisible(false);

                backtoGuide2.setVisible(true);
                Round_Frame.setVisible(true);
                title_g3.setVisible(true);
                guide_3.setVisible(true);
                doneGuide.setVisible(true);
                
                timerback3 = new Timer(17000, ae -> {
                    guide_3.setVisible(false);
                    Round_Frame.setVisible(false);
                    replayGuide_3.setVisible(true);
                    timerback3.stop();
                });
                timerback3.start();
                timerback3.restart();
            }
        });
        
        //Done guide!!
        doneGuide.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timer7.stop();
                timer8.stop();
                doneGuide.setVisible(false);
                backtoGuide2.setVisible(false);
                guide_3.setVisible(false);
                title_g3.setVisible(false);
                replayGuide_3.setVisible(false);
                step3_1.setVisible(false);
                step3_2.setVisible(false);

                startTutorial.setVisible(true);
                Instruction_logo.setVisible(true);
                //
            }
        });
        
         //Replay Guide 1:
        replayGuide_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                replayGuide_1.setVisible(false);
                guide_1.setVisible(true);
                Round_Frame.setVisible(true);
                
                timereplay = new Timer(17000, ae -> {
                    guide_1.setVisible(false);
                    Round_Frame.setVisible(false);
                    replayGuide_1.setVisible(true);
                    timereplay.stop();
                });
                timereplay.start();
                timereplay.restart();
            }
        });
        
         //Replay Guide 2:
        replayGuide_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                replayGuide_2.setVisible(false);
                guide_2.setVisible(true);
                Round_Frame.setVisible(true);
                
                timereplay2 = new Timer(22000, ae -> {
                    guide_2.setVisible(false);
                    Round_Frame.setVisible(false);
                    replayGuide_2.setVisible(true);
                    timereplay2.stop();
                });
                timereplay2.start();
                timereplay2.restart();
            }
        });
        
        //Replay Guide 3:
        replayGuide_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                replayGuide_3.setVisible(false);
                guide_3.setVisible(true);
                Round_Frame.setVisible(true);
                
                timereplay3 = new Timer(17000, ae -> {
                    guide_3.setVisible(false);
                    Round_Frame.setVisible(false);
                    replayGuide_3.setVisible(true);
                    timereplay3.stop();
                });
                timereplay3.start();
                timereplay3.restart();
            }
        });
    //(after...)
    }

    private void setGuide_1() {
        guide_1 = new JLabel();
        guide_1.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Guide 1. Normal Using.gif")));
        guide_1.setBounds(75, 20, 500, 378);

        step1_1 = new JLabel();
        step1_1.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Step 1.1.png")));
        step1_1.setBounds(110, 390, 400, 38);

        step1_2 = new JLabel();
        step1_2.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Step 1.2.png")));
        step1_2.setBounds(108, 420, 450, 74);
        step1_2.setVisible(false);

        step1_3 = new JLabel();
        step1_3.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Step 1.3.png")));
        step1_3.setBounds(140, 490, 363, 40);
        step1_3.setVisible(false);

        add(guide_1);
        add(step1_1);
        add(step1_2);
        add(step1_3);
    }

    private void setGuide_2() {
        guide_2 = new JLabel();
        guide_2.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Guide 2. Using with keywords.gif")));
        guide_2.setBounds(75, 20, 500, 378);

        step2_1 = new JLabel();
        step2_1.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Step 2.1.png")));
        step2_1.setBounds(110, 390, 430, 67);

        step2_2 = new JLabel();
        step2_2.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Step 2.2.png")));
        step2_2.setBounds(110, 450, 430, 103);
        step2_2.setVisible(false);

        step2_3 = new JLabel();
        step2_3.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Step 1.3.png")));
        step2_3.setBounds(140, 450, 363, 40);
        step2_3.setVisible(false);

        add(guide_2);
        add(step2_1);
        add(step2_2);
        add(step2_3);
    }

    private void setGuide_3() {
        guide_3 = new JLabel();
        guide_3.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Guide 3. Open PC app.gif")));
        guide_3.setBounds(75, 20, 500, 378);

        step3_1 = new JLabel();
        step3_1.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Step 3.1.png")));
        step3_1.setBounds(110, 390, 450, 121);

        step3_2 = new JLabel();
        step3_2.setIcon(new ImageIcon(GuideFrame.class.getResource("/Pictures/Step 3.2.png")));
        step3_2.setBounds(110, 460, 365, 40);
        step3_2.setVisible(false);

        add(guide_3);
        add(step3_1);
        add(step3_2);
    }

    public GuideFrame() {
        setLayout(null);
        setSize(650, 550);
        setContentPane(new JLabel(new ImageIcon(GuideFrame.class.getResource("/Pictures/Guide_ground.jpg"))));
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        try {
            setIconImage(ImageIO.read(GuideFrame.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}

        setExitButton();
        setStartTutorial();
    }
}
