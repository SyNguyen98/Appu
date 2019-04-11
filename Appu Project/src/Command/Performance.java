package Command;

import MainFrame.InputPanel;
import MainFrame.MainPanel;
import static MainFrame.MainPanel.answerPanel;
import static MainFrame.MainPanel.commandPanel;
import static MainFrame.MainPanel.iconLabel;
import static MainFrame.MainPanel.timeLabel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Performance {
    private static int length = 0;
    private static final JSONParser parser = new JSONParser();
    public static boolean online = true;
    
    private static String readDatabase(String keyString) {
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/Database/Answer.json"));
            for (Object obj : jsonArray) {                 
                JSONObject jsonObject = (JSONObject) obj;               
                String key = (String) jsonObject.get("Key");               
                if (keyString.equals(key)) {
                    String answer = (String) jsonObject.get("Answer");
                    return answer;
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {}
        return "Error 404!!!";
    }
    
    private static void setTime() {
        MainPanel.setTimeLabel();
        MainPanel.timeLabel.setText(new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()));
        MainPanel.timeLabel.setBounds(225, length, 50, 40);
    }
    
    private static void setCommand(String commandString, int width, int height) {
        MainPanel.setCommandPanel();
        MainPanel.commandPanel.setBounds(260 + (180 - width), 20 + height/2 + length, width + 25, height + 10);
        MainPanel.commandLabel.setText("<html>" + commandString.replace("@", "<br>") + "</html>");
        MainPanel.commandLabel.setBounds(15, 5, width, height);
    }
    
    private static void setAnswer() {
        MainPanel.setAnswerPanel();
        MainPanel.iconLabel.setBounds(10, commandPanel.getHeight() + 37 + length, 35, 35);
        MainPanel.iconLabel.setVisible(true);
        MainPanel.answerPanel.setBounds(55, commandPanel.getHeight() + length + 35, 160, 40);
        MainPanel.answerPanel.setVisible(true);
    }
    
    static void setMainPanel() {
        MainPanel.mainPanel.setPreferredSize(new Dimension(MainPanel.mainPanel.getWidth(), MainPanel.mainPanel.getHeight() + commandPanel.getHeight()));
        MainPanel.mainPanel.add(timeLabel);
        MainPanel.mainPanel.add(commandPanel);
        MainPanel.mainPanel.add(answerPanel);
        MainPanel.mainPanel.add(iconLabel);
        MainPanel.mainPanel.revalidate();
    }
    
    public static void Do() {
        InputPanel.inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {               
                String commandString = Proccess.makeNewLine(InputPanel.inputField.getText());
                int width = Proccess.width; 
                int height = Proccess.height;
   
                setTime();
                setCommand(commandString, width, height);
                setAnswer();
                setMainPanel();
                
                Computer.controlComputer();  
                
                if(Calculator.findKey(InputPanel.inputField.getText()))
                    MainPanel.answerLabel.setText(Calculator.getResult() + "  " + readDatabase("Math"));
                else
                    MainPanel.answerLabel.setText("<html>Yes, Master (○･∀･)b</html>");
                
                if(online) 
                    Internet.accessInternet();
                
                InputPanel.inputField.setText("");
                length += timeLabel.getHeight() + commandPanel.getHeight() + answerPanel.getHeight() + 10;
            }
        });

    }
}
