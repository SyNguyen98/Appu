package Command;

import Database.SQL;
import MainFrame.InputPanel;
import MainFrame.MainFrame;
import MainFrame.MainPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Performance {

    private static final SQL engSQL = new SQL("English");
    private static final SQL vietSQL = new SQL("Vietnam");
    public static boolean online;
    private static int length = 0;

    private static void setTime() {
        MainPanel.setTimeLabel();
        MainPanel.timeLabel.setText(new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()));
        MainPanel.timeLabel.setBounds(225, length, 50, 40);
    }

    private static void setCommand(String command, int width, int height) {
        MainPanel.setCommandPanel();
        MainPanel.commandPanel.setBounds(260 + (180 - width), 20 + height / 2 + length, width + 20, height + 10);
        MainPanel.commandLabel.setText("<html>" + command.replace("@", "<br>") + "</html>");
        MainPanel.commandLabel.setBounds(10, 5, width, height);
    }

    private static void setAnswer(String answer, int width, int height) {
        MainPanel.setAnswerPanel();
        MainPanel.iconLabel.setBounds(10, MainPanel.commandPanel.getHeight() + 37 + length, 35, 35);
        MainPanel.answerPanel.setBounds(55, MainPanel.commandPanel.getHeight() + length + 35, width + 20, height + 10);
        MainPanel.answerLabel.setText("<html>" + answer.replace("@", "<br>") + "</html>");
        MainPanel.answerLabel.setBounds(10, 5, width, height);
    }

    static void setMainPanel() {
        MainPanel.mainPanel.setPreferredSize(new Dimension(MainPanel.mainPanel.getWidth(), MainPanel.mainPanel.getHeight() + MainPanel.commandPanel.getHeight()));
        MainPanel.mainPanel.add(MainPanel.timeLabel);
        MainPanel.mainPanel.add(MainPanel.commandPanel);
        MainPanel.mainPanel.add(MainPanel.answerPanel);
        MainPanel.mainPanel.add(MainPanel.iconLabel);
        MainPanel.mainPanel.revalidate();
    }

    public static void Do() {
        InputPanel.inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setTime();

                String command = Proccess.makeNewLine(InputPanel.inputField.getText());
                int width = Proccess.width;
                int height = Proccess.height;
                setCommand(command, width, height);

                String answer = "";
                if ("english".equals(MainFrame.getLanguage()))
                    answer = engSQL.getAnswer(InputPanel.inputField.getText());
                else
                    answer = vietSQL.getAnswer(InputPanel.inputField.getText());
                answer = Proccess.makeNewLine(answer);
                width = Proccess.width;
                height = Proccess.height;
                setAnswer(answer, width, height);

                setMainPanel();

                online = true;
                Computer.controlComputer();

                if (Calculator.findKey(InputPanel.inputField.getText()))
                    MainPanel.answerLabel.setText(Calculator.getResult() + "  So easy ^^");

                if (online)
                    Internet.accessInternet();

                InputPanel.inputField.setText("");
                length += MainPanel.timeLabel.getHeight() + MainPanel.commandPanel.getHeight() + MainPanel.answerPanel.getHeight() + 10;
            }
        });

    }
}
