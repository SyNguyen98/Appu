package Performance;

import Database.EngSQL;
import Database.VietSQL;
import MainFrame.InputPanel;
import MainFrame.MainFrame;
import MainFrame.MainPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Performance {

    public static boolean online;
    private static int width, height;
    private static final int maxChar = 23;

    private static void setCommand(String command) {
        MainPanel.commandPanel.setBounds(260 + (180 - width), 20 + height / 2, width + 20, height + 10);
        MainPanel.commandLabel.setText("<html>" + command.replace("@", "<br>") + "</html>");
        MainPanel.commandLabel.setBounds(10, 5, width, height);
    }

    private static void setAnswer(String answer) {
        MainPanel.iconLabel.setBounds(10, MainPanel.commandPanel.getHeight() + 37, 35, 35);
        MainPanel.answerPanel.setBounds(55, MainPanel.commandPanel.getHeight() + 40, width + 20, height + 10);
        MainPanel.answerLabel.setText("<html>" + answer.replace("@", "<br>") + "</html>");
        MainPanel.answerLabel.setBounds(10, 5, width, height);
    }
    
    public static String makeNewLine(String command) {
        List<String> listStr = new ArrayList<>();  
        if(command.length() > maxChar) {
            int i, j = 0;
            for (i = maxChar; i < command.length(); i += maxChar) {
                if(command.charAt(i) == ' ') {
                    String str = command.substring(j, i++);
                    j = i;
                    listStr.add(str);
                } else if (command.charAt(i+1) == ' ') {
                    String str = command.substring(j, ++i);
                    j = i++;
                    listStr.add(str);
                } else {
                    while (command.charAt(i-1) != ' ') i--;
                    String str = command.substring(j, --i);
                    j = i++;
                    listStr.add(str);
                }
            }
                String str = command.substring(j);
                listStr.add(str);
                width = maxChar * 8;    
        }
        else {
            listStr.add(command);  
            width = command.length() * 8;   
        }
        height = listStr.size() * 23;
        command = "";
        for (String str : listStr)
            command += str + "@";         // @ is the mark for new line
        return command;
    }

    public static void Do() {
        InputPanel.inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MainPanel.timeLabel.setText(new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()));
                
                String com = InputPanel.inputField.getText();

                String command = makeNewLine(com);
                setCommand(command);

                String answer;
                if ("english".equals(MainFrame.getLanguage()))
                    answer = EngSQL.getAnswer(com.toLowerCase());
                else
                    answer = VietSQL.getAnswer(com.toLowerCase());
                answer = makeNewLine(answer);
                setAnswer(answer);

                online = true;
                Computer.controlComputer();

                if (Calculator.findKey(com))
                    MainPanel.answerLabel.setText(Calculator.getResult() + "  So easy ^^");

                if (online)
                    Internet.accessInternet();

                InputPanel.inputField.setText("");
            }
        });

    }
}
