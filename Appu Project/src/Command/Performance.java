package Command;

import Database.EngSQL;
import Database.VietSQL;
import MainFrame.InputPanel;
import MainFrame.MainFrame;
import MainFrame.MainPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Performance {

    public static boolean online;

    private static void setCommand(String command, int width, int height) {
        MainPanel.commandPanel.setBounds(260 + (180 - width), 20 + height / 2, width + 20, height + 10);
        MainPanel.commandLabel.setText("<html>" + command.replace("@", "<br>") + "</html>");
        MainPanel.commandLabel.setBounds(10, 5, width, height);
    }

    private static void setAnswer(String answer, int width, int height) {
        MainPanel.iconLabel.setBounds(10, MainPanel.commandPanel.getHeight() + 37, 35, 35);
        MainPanel.answerPanel.setBounds(55, MainPanel.commandPanel.getHeight() + 35, width + 20, height + 10);
        MainPanel.answerLabel.setText("<html>" + answer.replace("@", "<br>") + "</html>");
        MainPanel.answerLabel.setBounds(10, 5, width, height);
    }

    public static void Do() {
        InputPanel.inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MainPanel.timeLabel.setText(new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()));

                String command = Proccess.makeNewLine(InputPanel.inputField.getText());
                int width = Proccess.width;
                int height = Proccess.height;
                setCommand(command, width, height);

                String answer;
                if ("english".equals(MainFrame.getLanguage())) {
                    answer = EngSQL.getAnswer(InputPanel.inputField.getText());
                }
                else {
                    answer = VietSQL.getAnswer(InputPanel.inputField.getText());
                }
                answer = Proccess.makeNewLine(answer);
                width = Proccess.width;
                height = Proccess.height;
                setAnswer(answer, width, height);

                online = true;
                Computer.controlComputer();

                if (Calculator.findKey(InputPanel.inputField.getText()))
                    MainPanel.answerLabel.setText(Calculator.getResult() + "  So easy ^^");

                if (online)
                    Internet.accessInternet();

                InputPanel.inputField.setText("");
            }
        });

    }
}
