package Database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class VietSQL extends SQL {

    public VietSQL() {
        try {
            connection = DriverManager.getConnection("jdbc:derby:vietSQL;create=true");
            createTable();
        } catch (SQLException ex) {}
    }

    private void insertTable() {
        insert("error", "Em không hiểu ý ngài, thôi thì hỏi google nhé :O", "Rất xin lỗi, yêu cầu của ngài em chưa được huấn luyện để thực hiện, nhưng google thì có ^^", "Rất tiếc, em chưa được lập trình để thực hiện yêu cầu đó, còn Google-san thì rồi", "Thành thật xin lỗi, em không thể thực hiện được câu lệnh của ngài, để em tra google đã nhé >_<");
        insert("video", "Thật nhiều video thú vị, ngài chọn một cái và xem nhé!", "Em và ngài cùng nhau xem nhé …", "Ngài muốn xem video nào? Click chọn nhé!", "Xem em tìm được gì cho ngài nè …");
        insert("hình ảnh", "Kiếm được rồi, hiện hình lên thôi !!", "Thật đẹp, thật dễ thương…", "Ngài muốn tải ảnh về làm ảnh nền hả? Em có thể giúp đó", "Nhiều ảnh quá, ngài xem từ từ nhé.");
        insert("nhạc", "Làm việc nhiều rồi, thư giãn một chút thôi…", "Hình như bài này đang là hot trend thì phải?!", "Em kiếm ra rồi, mà nhiều bài và ca sĩ quá, ngài tự chọn nhé!", "Bài hát của ngài đây…");
        insert("dịch", "Từ này dễ mà … … … em quên mất rồi, thôi để tra google :D", "Đây, cái nào khó thì mình cứ xài tool ^_^ ", "Từ này nghĩa là … 世界! (Tui đùa đó :v, kết quả dịch đây)", "Úm ba la, taa daa ");
        insert("bản đồ", "Đi đâu thì nhớ *Tắt máy* rồi hẵng đi nhé!", "Đây là chỉ dẫn đường đi từ đây tới đó…", "Đi đâu thì đi, nhớ về nhà ăn tối cùng em nhé! <3", "Let go !!!");
        insert("facebook", "Xem có gì hot không nào :/", "Ngài đang có tâm trạng hả? Có muốn đăng status tâm sự gì không?", "Hmm, lên check xem inbox có ai nhắn tin không nào…", "Hình như hôm nay được nghỉ, lên facebook check lịch lại nào!!");
        insert("mail", "Check mail thường xuyên, xem có CTY nào mời đi phỏng vấn không nhé! ", "Làm bài xong rồi, lên mail nộp bài thôi…", "Hình như không có mail nào mới cả đâu…", "TMA chưa gửi mail đâu, hình như mới có mấy cái mail của ITViec thôi à.");
        insert("web", "Thông tin mà bạn cần tìm đây…", "Cần gì cứ nhắn cho em nhé, ba cái này đơn giản á mà…", "Thứ ngài cần tìm kiếm đây…", "Chờ một chút nào, hình như mạng hơi lag…");
        insert("mở", "Ứng dụng của bạn sẽ hiện lên nhanh thôi…", "Mở nó lên nào…", "Chờ một chút nhé, nó lên liền ngay thôi…", "Yêu cầu của ngài sẽ được thực hiện … ngay tức khắc!");
        insert("ngủ", "Nghỉ ngơi một lát cho thoải mái rồi làm việc tiếp sau nào.", "Đi kiếm gì ăn uống rồi quay lại làm việc nhé!", "Nghỉ ngơi thôi !!!", "Ra ngoài chơi xíu nào…");
        insert("tắt máy", "Hôm nay làm việc đủ rồi, nghỉ ngơi đi ngủ thôi.", "Chào tạm biệt, mai lại gọi em tới giúp ngài nhé!", "Cảm ơn vì ngày hôm nay, em sẽ nhớ ngài <3", "Tạm biệt nhé, hẹn mai gặp lại ;)");
        insert("bạn là ai", "Em là i.Sekai, trợ lý ảo trong việc dùng máy tính trên hệ điều hành Windows.", "Ngài có thể vào cài đặt, sẽ thấy thông tin về em nằm tại đó.", "Em là trợ lý ảo của ngài.", "Em là phần mềm trợ lý giúp được rất nhiều thứ hữu ích!");
        insert("tôi là ai", "Hãy nói tên ngài cho em nghe, em sẽ ghi nhớ…", "Hình như ngài chưa nói tên ngài cho em biết :/", "Em không nhớ ngài có nói tên cho em nghe…", "Xin lỗi, em không, em chỉ biết ngài là chủ nhân của em thôi.");
        insert("giúp được gì", "Bạn có thể vào cài đặt, xem thông tin của tôi và biết tôi có thể làm gì", "Tôi có thể giúp được bạn rất nhiều thứ…", "Hãy khám phá tôi, rồi bạn sẽ phải thích tôi thôi", "Tôi giúp cho bạn được rất nhiều thứ… bạn có thể tự khám phá ra và sẽ thích tôi…");
        insert("nhớ chưa", "Nhớ rồi ạ", "Đã rõ!", "Em nhớ rồi", "Em đã rõ rồi!");
        insert("cách sử dụng", "Ngài có thể vào cài đặt, rồi mở phần Guide lên, em sẽ hướng dẫn ngài các bước cơ bản để sử dụng.", "Phần Guide có thể trả lời ngài các câu hỏi đó.", "Hãy đọc hướng dẫn sử dụng trước khi dùng nhé :D :D", "Tự mò đi ạ :)");
    }

    public static String exceptionCase(String command) {
        if (command.contains("là ai") || command.contains("là gì"))
            if (command.contains("em") || command.contains("bạn") || command.contains("mày"))
                return "bạn là ai";
            else
                return "tôi là ai";
        if ((command.contains("xài") || command.contains("sử dụng")) && (command.contains("làm sao") || command.contains("như thế nào") ||  command.contains("cách")))
            return "cách sử dụng";
        return "error";
    }

    public static String getAnswer(String command) {
        VietSQL sql = new VietSQL();
        String cmd = checkAnswer(command, "Viet");
        if (cmd.equals(command))
            cmd = exceptionCase(cmd);
        String answer = getValue(sql, cmd);
        return answer;
    }

//    public static void main(String[] args) {
//        VietSQL sql = new VietSQL();
//        sql.insertTable();
//    }
}
