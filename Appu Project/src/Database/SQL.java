package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {

    private static Connection connection;
    private static int count = 0;

    public SQL(String string) {
        try {
            if (string.equalsIgnoreCase("English")) 
                connection = DriverManager.getConnection("jdbc:derby:engSQL;create=true");
            else
                connection = DriverManager.getConnection("jdbc:derby:vietSQL;create=true");
        } catch (SQLException ex) {}
    }

    public void createTable() {
        try {
            connection.createStatement().execute("CREATE TABLE MYTABLE(title varchar(50),values1 varchar(500),values2 varchar(500),values3 varchar(500),values4 varchar(500))");
        } catch (SQLException ex) {}
    }

    private void insert(String title, String values1, String values2, String values3, String values4) {
        try {
            connection.createStatement().execute("INSERT INTO MYTABLE values('" + title + "','" + values1 + "','" + values2 + "','" + values3 + "','" + values4 + "')");
        } catch (SQLException ex) {}
    }
    
    private void delete(String title) {
        try {
            connection.createStatement().executeUpdate("DELETE FROM MYTABLE where title = '" + title + "'");
        } catch (SQLException ex) {}
    }

    private void insertTableViet() {
        insert("error", "Tôi không hiểu ý bạn, bạn có thể hỏi lại chi tiết hơn không? :O", "Rất xin lỗi, yêu cầu của bạn tôi chưa được huấn luyện để thực hiện, xin hãy cho tôi thời gian học hỏi thêm :(", "Rất tiếc, tôi chưa được lập trình để thực hiện yêu cầu của bạn, bạn có thể yêu cầu câu lệnh khác ạ. ", "Thành thật xin lỗi, tôi không thể thực hiện được câu lệnh của bạn, tôi sẽ đọc thêm sách để hiểu thêm về vấn đề này >_<");
        insert("video", "Thật nhiều video thú vị, bạn chọn một cái và xem nhé!", "Tôi và bạn cùng nhau xem nhé …", "Bạn muốn xem video nào về nội dung này nào? Click chọn nhé!", "Xem tôi tìm được gì cho bạn nè …");
        insert("hình ảnh", "Kiếm được rồi, hiện hình lên thôi !!", "Thật đẹp, thật dễ thương…", "Bạn muốn tải ảnh về làm ảnh nền hả? Tôi có thể giúp bạn đó", "Nhiều ảnh quá, bạn xem từ từ nhé.");
        insert("nhạc", "Làm việc nhiều rồi, thư giãn một chút thôi…", "Hình như bài này đang là hot trend thì phải?!", "Tôi kiếm ra rồi, mà nhiều bài và ca sĩ khác nhau quá, bạn tự chọn và nghe nhé!", "Bài hát của bạn đây…");
        insert("dịch", "Từ này dễ mà … cơ mà … hmm tôi cũng quên mất rồi, thôi để tra google :D", "Đây, cái nào khó thì mình cứ xài tool ^_^ ", "Từ này nghĩa là … con chó con đó! (Tui đùa đó :v, kết quả dịch đây)", "Úm ba la, ra nghĩa của từ: ");
        insert("bản đồ", "Đi đâu thì nhớ 'Tắt máy' máy rồi hãng đi nhé!", "Đây là chỉ dẫn đường đi từ đây tới đó…", "Đi đâu thì đi, nhớ về nhà ăn tối cùng gia đình, bạn nhé! <3", "Let go !!!");
        insert("facebook", "Xem có gì hot không nào :/", "Bạn đang tâm trạng hả, có muốn đăng status tâm sự gì không?", "Hmm, lên check xem inbox có ai nhắn tin không nào…", "Hình như hôm nay được nghỉ, lên facebook check lịch lại nào!!");
        insert("mail", "Check mail thường xuyên, xem có CTY nào mới đi phỏng vấn không, bạn nhé! ", "Làm bài xong rồi, lên mail nộp bài thôi…", "Hình như không có mail nào mới cả đâu…", "TMA chưa gửi mail cho bạn đâu, hình như mới có mấy cái mail của IT Viec thôi à.");
        insert("web", "Thông tin mà bạn cần tìm đây…", "Cần gì cứ nhắn cho tôi nhé, ba cái này đơn giản á mà…", "Thứ bạn cần tìm kiếm đây…", "Chờ một chút nào, hình như mạng nhà hơi lag…");
        insert("mở", "Ứng dụng của bạn sẽ hiện lên nhanh thôi…", "Mở nó lên nào…", "Chờ một chút nhé, nó lên liền ngay thôi…", "Yêu cầu của bạn sẽ được thực hiện … ngay tức khắc!");
        insert("ngủ", "Nghỉ ngơi một lát cho thoải mái rồi làm việc tiếp sau nào.", "Đi kiếm gì ăn uống rồi quay lại làm việc nhé!", "Nghỉ ngơi thôi !!!", "Ra ngoài chơi xíu nào…");
        insert("tắt máy", "Hôm nay làm việc đủ rồi, nghỉ ngơi đi ngủ thôi.", "Chào tạm biệt, mai lại gọi tôi tới giúp bạn nhé!", "Cảm ơn bạn vì ngày hôm nay, tôi sẽ nhớ bạn <3", "Tạm biệt nhé, hẹn mai gặp lại ;)");
        insert("bạn là ai", "Tôi là i.Sekai, trợ lý ảo cho bạn trong việc dùng máy tính trên hệ điều hành Windows.", "Bạn có thể vào cài đặt, bạn sẽ thấy thông tin về tôi nằm tại đó.", "Tôi là trợ lý ảo của bạn.", "Tôi là phần mềm trợ lý giúp cho bạn được rất nhiều thứ hữu ích!");
        insert("mày là ai", "Tôi là i.Sekai, trợ lý ảo cho bạn trong việc dùng máy tính trên hệ điều hành Windows.", "Bạn có thể vào cài đặt, bạn sẽ thấy thông tin về tôi nằm tại đó.", "Tôi là trợ lý ảo của bạn.", "Tôi là phần mềm trợ lý giúp cho bạn được rất nhiều thứ hữu ích!");
        insert("biết tôi là ai không", "Hãy nói tên bạn cho tôi nghe, tôi sẽ ghi nhớ…", "Hình như bạn chưa nói tên bạn cho tôi biết :/", "Tôi không nhớ bạn có nói tên bạn cho tôi nghe…", "Xin lỗi, tôi không, tôi chỉ biết bạn là chủ nhân của tôi.");
        insert("biết tao là ai không", "Hãy nói tên bạn cho tôi nghe, tôi sẽ ghi nhớ…", "Hình như bạn chưa nói tên bạn cho tôi biết :/", "Tôi không nhớ bạn có nói tên bạn cho tôi nghe…", "Xin lỗi, tôi không, tôi chỉ biết bạn là chủ nhân của tôi.");
        insert("mày giúp được gì cho tao", "Bạn có thể vào cài đặt, xem thông tin của tôi và biết tôi có thể làm g", "Tôi có thể giúp được bạn rất nhiều thứ…", "Hãy khám phá tôi, rồi bạn sẽ phải thích tôi thôi", "Tôi giúp cho bạn được rất nhiều thứ… bạn có thể tự khám phá ra và sẽ thích tôi…");
        insert("bạn giúp được gì cho tôi", "Bạn có thể vào cài đặt, xem thông tin của tôi và biết tôi có thể làm g", "Tôi có thể giúp được bạn rất nhiều thứ…", "Hãy khám phá tôi, rồi bạn sẽ phải thích tôi thôi", "Tôi giúp cho bạn được rất nhiều thứ… bạn có thể tự khám phá ra và sẽ thích tôi…");
        insert("nhớ chưa", "Tôi nhớ rồi", "Tôi đã rõ rồi!", "Tôi nhớ rồi", "Tôi đã rõ rồi!");
        insert("cách sử dụng", "Bạn có thể vào cài đặt, rồi mở phần Guide lên, tôi sẽ hướng dẫn bạn các bước cơ bản để dùng tôi.", "Phần Guide có thể trả lời bạn các câu hỏi đó.", "Hãy đọc hướng dẫn sử dụng trước khi dùng :D :D", "Bạn có thể vào cài đặt, rồi mở phần Guide lên, tôi sẽ hướng dẫn bạn các bước cơ bản để dùng tôi.");
        insert("làm sao để sử dụng", "Bạn có thể vào cài đặt, rồi mở phần Guide lên, tôi sẽ hướng dẫn bạn các bước cơ bản để dùng tôi.", "Phần Guide có thể trả lời bạn các câu hỏi đó.", "Hãy đọc hướng dẫn sử dụng trước khi dùng :D :D", "Bạn có thể vào cài đặt, rồi mở phần Guide lên, tôi sẽ hướng dẫn bạn các bước cơ bản để dùng tôi.");
        insert("xài như thế nào", "Bạn có thể vào cài đặt, rồi mở phần Guide lên, tôi sẽ hướng dẫn bạn các bước cơ bản để dùng tôi.", "Phần Guide có thể trả lời bạn các câu hỏi đó.", "Hãy đọc hướng dẫn sử dụng trước khi dùng :D :D", "Bạn có thể vào cài đặt, rồi mở phần Guide lên, tôi sẽ hướng dẫn bạn các bước cơ bản để dùng tôi.");
        insert("tên tôi là gì", "Rất xin lỗi, vì tôi chỉ mới được sinh ra từ hôm qua, nên trí nhớ tôi không thể lưu trữ quá nhiều.", "Xin hãy cho tôi thêm thời gian để khắc ghi tên bạn vào tim… (nhưng tôi không có tim thật đâu)", "Rất xin lỗi, vì tôi chỉ mới được sinh ra từ hôm qua, nên trí nhớ tôi không thể lưu trữ quá nhiều.", "Xin hãy cho tôi thêm thời gian để khắc ghi tên bạn vào tim… (nhưng tôi không có tim thật đâu)");
        insert("tên tao là gì", "Rất xin lỗi, vì tôi chỉ mới được sinh ra từ hôm qua, nên trí nhớ tôi không thể lưu trữ quá nhiều.", "Xin hãy cho tôi thêm thời gian để khắc ghi tên bạn vào tim… (nhưng tôi không có tim thật đâu)", "Rất xin lỗi, vì tôi chỉ mới được sinh ra từ hôm qua, nên trí nhớ tôi không thể lưu trữ quá nhiều.", "Xin hãy cho tôi thêm thời gian để khắc ghi tên bạn vào tim… (nhưng tôi không có tim thật đâu)");
    }
    
    private void insertTableEng() {
        insert("error", "I do not understand, can you repeat your request?", "I am so sorry, I have not studied how to do this yet, please give me more time to be better.","I can not do this right now, can you resquest other questions?","I am so sorry about this problem, because I have not seen it before…");
        insert("video", "So many interesting videos, let is watch it!", "Let is watch it!","Choose and click on once that you want to watch.","Let is see… what can I found…");
        insert("picture", "Here are your pictures!", "So beautiful, so pretty!!","Do you want to change your wallpaper? I can do it for you!","So many beautiful pictures, go and see them.");
        insert("music", "Many works to do, relax for a moment…", "This song is a hot-trend now?","I found it, hmm nope, so many result … get at your choice!","Here is your song!");
        insert("translate", "It is really easy… but… I am either forget meaning of its :3 ", "Here!! Using my tool …","Meaning of this word is… 'I do not know' :v (Just kiding ^^)","Here you are !!!");
        insert("map", "Remember to *shut (me) down* before you go. ", "Here is the way …","Do not forget *way back home*.","Let is go !!!");
        insert("facebook", "Let is see… something news?", "Do you want to write something to newfeed? But I can not do this for you :P","Hmm, anyone is chatting with you…","Let is see… something news?");
        insert("mail", "Remember to check mail regularly… some company will send you request for something… that you really need", "Exercises are done! Let is submit them…","Let is see… It is have not something new…","Exercises are done! Let is submit them…");
        insert("web", "This is your information.", "Whatever you want, just talk it to me.","Here you are !!!","Oh wait?! The internet today feel like has something stuck… I feel it is really lag…");
        insert("open", "Your application will appear soon.", "Let is open it!","Wait a minute, it will be opened!","Your request will be done right now!");
        insert("sleep", "Take a nap, then we will continue it.", "Find something to eat and drink, your mood will be better.","It is break time…","Go out time…");
        insert("who are you", "I am i.Sekai, your virtual assistant in the way of using computer.", "You also see my information in Settings -> Information.","I am your friend, your best assistant.","I am i.Sekai, your virtual assistant in the way of using computer.");
        insert("do you know me", "Tell me your name, I will never forget you!", "Hmm, I do not think that I have known your name…","You haven’t told your name to me yet!","Sorry, I just know that you are my boss!");
        insert("what can you do for me", "I can do many things for you.", "Let is explore me, you will like me soon.","You can see what can I do for you in my Settings.","Let is explore me, you will like me soon.");
        insert("got it?", "Yes! Of course.", "Okay, I got it.","Yes! Of course.","Okay, I got it.");
        insert("how to use", "You can click in Settings -> Guide to know how to using me.", "Guide will tell you what to do next :)","Read carefully intructions before using :P","Guide will tell you what to do next :)");
        insert("what is my name", "I am so sorry, I need time to remember that…", "Give me more time to take your name into my heart (thought I have not a really heart…)", "I am so sorry, I need time to remember that…", "Give me more time to take your name into my heart (thought I have not a really heart…)");
        insert("shut down", "Today is enough, we can go to sleep now…", "Goodbye, see you tomorrow.","Thank you for this day, I will miss you!!","See you tomorrow…");
    }

    private void deleteTableViet() {
        delete("error");
        delete("video");
        delete("hình ảnh");
        delete("nhạc");
        delete("dịch");
        delete("bản đồ");
        delete("facebook");
        delete("mail");
        delete("web");
        delete("mở");
        delete("sleep");
        delete("shut down");
        delete("bạn là ai");
        delete("mày là ai");
        delete("biết tôi là ai không");
        delete("biết tao là ai không");
        delete("mày giúp được gì cho tao");
        delete("bạn giúp được gì cho tôi");
        delete("nhớ chưa");
        delete("cách sử dụng");
        delete("làm sao để sử dụng");
        delete("xài như thế nào");
        delete("tên tôi là gì");
        delete("tên tao là gì");
    }
    
    private void deleteTableEng() {
        delete("error");
        delete("video");
        delete("picture");
        delete("music");
        delete("translate");
        delete("map");
        delete("facebook");
        delete("mail");
        delete("web");
        delete("open");
        delete("sleep");
        delete("shut down");
        delete("who are you");
        delete("do you know me");
        delete("what can you do for me");
        delete("got it?");
        delete("how to use");
        delete("what is my name");
    }

    public String check(String title) {
        char arr[] = title.toCharArray();
        int n = arr.length;
        if (title == "tắt máy" || title == "bạn là ai" || title == "mày là ai" || title == "biết tôi là ai không" || title == "biết tao là ai không" || title == "mày giúp được gì cho tao" || title == "bạn giúp được gì cho tôi" || title == "tên tôi là gì" || title == "tên tao là gì") {
            return title;
        } else {
            for (int i = 0; i < n; i++) {
                if (arr[i] == ' ') {
                    return String.copyValueOf(arr, 0, i);
                }
                if ((i == n - 1 && arr[i] != ' ')) {
                    return title;
                }
            }
        }
        return null;
    }

    public String getAnswer(String command) {
        String title = check(command);
        try {
            String answer;
            switch (count++ % 4) {
                case 0:
                    answer = "values1";
                    break;
                case 1:
                    answer = "values2";
                    break;
                case 2:
                    answer = "values3";
                    break;
                default:
                    answer = "values4";
                    break;
            }
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT " + answer + " FROM MYTABLE where title like '%" + title + "%'");
            if (resultSet.next()) {
                return resultSet.getString(answer);
            }
            resultSet = statement.executeQuery("SELECT " + answer + " FROM MYTABLE where title like '%error%'");
            if (resultSet.next()) {
                return resultSet.getString(answer);
            }
        } catch (Exception e) {}
        return null;
    }
    
//    public static void main(String[] args) {
//        SQL sql = new SQL("Viet");
//        sql.createTable();
//        sql.insertTableViet();
//    }
}
