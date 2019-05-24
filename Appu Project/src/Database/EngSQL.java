package Database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class EngSQL extends SQL {

    public EngSQL() {
        try {
            connection = DriverManager.getConnection("jdbc:derby:engSQL;create=true");
            createTable();
        } catch (SQLException ex) {}
    }

    private void insertTableEng() {
        insert("error", "I do not understand, let me check google >_<", "I am so sorry, I have not studied how to do this yet, but google did :P","I can not do this right now, please ask Google-san to do this?","I am so sorry about this problem, maybe google can help you");
        insert("video", "So many interesting videos, let is watch it!", "Let is watch it!","Choose and click on once that you want to watch.","Let is see… what can I found…");
        insert("picture", "Here are your pictures!", "So beautiful, so pretty!!","Do you want to change your wallpaper? I can do it for you!","So many beautiful pictures, go and see them.");
        insert("music", "Many works to do, relax for a moment…", "This song is a hot-trend now?","I found it, hmm nope, so many result … get at your choice!","Here is your song!");
        insert("translate", "It is really easy… but… I am either forget meaning of its :3 ", "Here!! Using my tool …","Meaning of this word is… 'I do not know' :v (Just kiding ^^)","Here you are !!!");
        insert("map", "Remember to *shut (me) down* before you go. ", "Here is the way …","Do not forget *way back home*.","Let is go !!!");
        insert("facebook", "Let is see… something news?", "Do you want to write something to newfeed? But I can not do this for you :P","Hmm, anyone is chatting with you…","Let is see… something news?");
        insert("mail", "Remember to check mail regularly … some company will send you request for something… that you really need", "Exercises are done! Let is submit them…","Let is see… It is have not something new…","Exercises are done! Let is submit them…");
        insert("web", "This is your information.", "Whatever you want, just talk it to me.","Here you are !!!","Oh wait?! The internet today feel like has something stuck… I feel it is really lag…");
        insert("open", "Your application will appear soon.", "Let is open it!","Wait a minute, it will be opened!","Your request will be done right now!");
        insert("sleep", "Take a nap, then we will continue it.", "Find something to eat and drink, your mood will be better.","It is break time…","Go out time…");
        insert("who are you", "I am i.Sekai, your virtual assistant in the way of using computer.", "You can see my information in Settings -> Information.","I am your friend, your best assistant.","I am i.Sekai, your virtual assistant in the way of using computer.");
        insert("do you know me", "Tell me your name, I will never forget you!", "Hmm, I do not think that I have known your name…","You haven’t told your name to me yet!","Sorry, I just know that you are my boss!");
        insert("what can you do for me", "I can do many things for you.", "Let is explore me, you will like me soon.","You can see what can I do for you in my Settings.","Let is explore me, you will like me soon.");
        insert("got it?", "Yes! Of course.", "Okay, I got it.","Yes! Of course.","Okay, I got it.");
        insert("how use", "You can click in Settings -> Guide to know how to using me.", "Guide will tell you what to do next :)","Read carefully intructions before using :P","Guide will tell you what to do next :)");
        insert("what is my name", "I am so sorry, I need time to remember that …", "Give me more time to take your name into my heart (thought I have not a really heart …)", "I am so sorry, I need time to remember that…", "Give me more time to take your name into my heart (thought I have not a really heart…)");
        insert("shut down", "Today is enough, we can go to sleep now…", "Goodbye, see you tomorrow.","Thank you for this day, I will miss you!!","See you tomorrow …");
    }

    public static String exceptionCase(String command) {
        if (command.contains("who are you") || command.contains("your name"))
            return "who are you";
        if (command.contains("how") && command.contains("use"))
            return "how use";
        return "error";
    }

    public static String getAnswer(String command) {
        EngSQL sql = new EngSQL();
        String cmd = checkAnswer(command, "English");
        if (cmd.equals(command))
            cmd = exceptionCase(cmd);
        String answer = getValue(sql, cmd);
        return answer;
    }
    
//    public static void main(String[] args) {
//        EngSQL sql = new EngSQL();
//        sql.insertTableEng();
//    }
}
