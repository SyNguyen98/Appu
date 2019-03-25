package Command;

import APPU.MainPanel;
import static APPU.MainPanel.answerPanel;
import static APPU.MainPanel.commandPanel;
import static APPU.MainPanel.iconLabel;
import static APPU.MainPanel.timeLabel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Performance {
    private static int length = 0;
    
    public static void Do() {
        MainPanel.inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MainPanel.setTime();
                MainPanel.setCommand();
                MainPanel.setAnswer();
                
                String commandString = Proccess.makeNewLine(MainPanel.inputField.getText());
                int width = Proccess.width; 
                int height = Proccess.height;
                
                MainPanel.timeLabel.setText(new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()));
                MainPanel.timeLabel.setBounds(225, length, 50, 40);
                
                MainPanel.commandPanel.setBounds(260 + (180 - width), 20 + height/2 + length, width + 25, height + 10);
                MainPanel.commandLabel.setText("<html>" + commandString.replace("@", "<br>") + "</html>");
                MainPanel.commandLabel.setBounds(15, 5, width, height);
                
                MainPanel.mainPanel.setPreferredSize(new Dimension(MainPanel.mainPanel.getWidth(), MainPanel.mainPanel.getHeight() + commandPanel.getHeight()));
                MainPanel.mainPanel.add(timeLabel);
                MainPanel.mainPanel.add(commandPanel);
                MainPanel.mainPanel.add(answerPanel);
                MainPanel.mainPanel.add(iconLabel);
                MainPanel.mainPanel.revalidate();
                
                Commands.online = true;
                Commands.controlComputer();
                if(MainPanel.inputField.getText().charAt(MainPanel.inputField.getText().length() - 1) == '=')
                    MainPanel.answerLabel.setText("= " + Calculator.doMath() + "   So easy ^^");
                else
                    MainPanel.answerLabel.setText("<html>Yes, Master  (○･∀･)b</html>");
                if(Commands.online) 
                    Commands.accessInternet();
                
                MainPanel.inputField.setText("");
                MainPanel.iconLabel.setVisible(true);
                MainPanel.answerPanel.setBounds(55, commandPanel.getHeight() + length + 35, 160, 40);
                MainPanel.answerPanel.setVisible(true);
                MainPanel.iconLabel.setBounds(10, commandPanel.getHeight() + 37 + length, 35, 35);

                length += timeLabel.getHeight() + commandPanel.getHeight() + answerPanel.getHeight() + 10;
            }
        });

    }
}
