package Command;

import APPU.MainPanel;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Commands {
    private static final Desktop desktop = Desktop.getDesktop();
    public static boolean online;
    
    public static void accessInternet() {   
        String command = MainPanel.inputField.getText();
        command = command.replace(" ", "+");
        String[] key = {"#video",
                        "#picture",
                        "#face",
                        "#song",
                        "#translate",
                        "#map",
                        "#jam",
                        "#web"};
        String name = "";
        int i;
        for (i = 0; i < key.length; i++ ) {
            int KeyIndex = command.indexOf(key[i]);
            if(KeyIndex != -1) {
                KeyIndex += key[i].length();
                name = command.substring(++KeyIndex, command.length());
                break;
            }
        }
        String[] URL = {"https://www.youtube.com/results?search_query=" + name,
                        "https://www.google.com/search?q=" + name + "&source=lnms&tbm=isch&sa=X&ved=0ahUKEwje8pbnxvvgAhVaUN4KHfIUBtAQ_AUIDigB&biw=1366&bih=695",
                        "https://www.facebook.com/",
                        "https://zingmp3.vn/tim-kiem/bai-hat.html?q=" + name,
                        "https://translate.google.com/?hl=vi#view=home&op=translate&sl=en&tl=vi&text=" + name,
                        "https://www.google.com/maps/dir/" + name,
                        "https://www.google.com/maps/dir/" + name +"/data=!4m2!4m1!3e0!5m1!1e1/",
                        "https://www." + name,
                        "https://www.google.com/search?q=" + command};
        String url = URL[i];
        try {
            desktop.browse(new URI(url));
        } catch (IOException | URISyntaxException e) {}
    }
    
    public static void controlComputer() {
        String command = MainPanel.inputField.getText();
        if(command.contains("shut down")) {
            Runtime runtime = Runtime.getRuntime();
            try {
                Process proc = runtime.exec("shutdown -s -t 0");
            } catch (IOException ex) {
            }
            System.exit(0);
            online = false;
        }
        if(command.contains("go to sleep")) {
            Runtime runtime = Runtime.getRuntime();
            try {
                Process proc = runtime.exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
            } catch (IOException ex) {
            }
            System.exit(0);
            online = false;
        }
        if(command.contains("open word")) {
            try {
                desktop.open(new File("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\WINWORD.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            online = false;
        }
        if(command.contains("open powerpoint")) {
            try {
                desktop.open(new File("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\POWERPNT.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            online = false;
        }
        if(command.contains("open excel")) {
            try {
                desktop.open(new File("C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.exe"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            online = false;
        }
    }
}