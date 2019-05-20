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
        insert("error", "Tôi không hiểu ý bạn, bạn có thể hỏi lại chi tiết hơn không? :O", "Rất xin lỗi, yêu cầu của bạn tôi chưa được huấn luyện để thực hiện, xin hãy cho tôi thời gian học hỏi thêm :(", "Rất tiếc, tôi chưa được lập trình để thực hiện yêu cầu của bạn, bạn có thể yêu cầu câu lệnh khác ạ. ", "Thành thật xin lỗi, tôi không thể thực hiện được câu lệnh của bạn, tôi sẽ đọc thêm sách để hiểu thêm về vấn đề này >_<");
        insert("video", "Thật nhiều video thú vị, bạn chọn một cái và xem nhé!", "Tôi và bạn cùng nhau xem nhé …", "Bạn muốn xem video nào về nội dung này nào? Click chọn nhé!", "Xem tôi tìm được gì cho bạn nè …");
        insert("hình ảnh", "Kiếm được rồi, hiện hình lên thôi !!", "Thật đẹp, thật dễ thương…", "Bạn muốn tải ảnh về làm ảnh nền hả? Tôi có thể giúp bạn đó", "Nhiều ảnh quá, bạn xem từ từ nhé.");
        insert("nhạc", "Làm việc nhiều rồi, thư giãn một chút thôi…", "Hình như bài này đang là hot trend thì phải?!", "Tôi kiếm ra rồi, mà nhiều bài và ca sĩ khác nhau quá, bạn tự chọn và nghe nhé!", "Bài hát của bạn đây…");
        insert("dịch", "Từ này dễ mà … … … em quên mất rồi, thôi để tra google :D", "Đây, cái nào khó thì mình cứ xài tool ^_^ ", "Từ này nghĩa là … 世界! (Tui đùa đó :v, kết quả dịch đây)", "Úm ba la, taa daa ");
        insert("bản đồ", "Đi đâu thì nhớ 'Tắt máy' máy rồi hãng đi nhé!", "Đây là chỉ dẫn đường đi từ đây tới đó…", "Đi đâu thì đi, nhớ về nhà ăn tối cùng gia đình, bạn nhé! <3", "Let go !!!");
        insert("facebook", "Xem có gì hot không nào :/", "Bạn đang tâm trạng hả, có muốn đăng status tâm sự gì không?", "Hmm, lên check xem inbox có ai nhắn tin không nào…", "Hình như hôm nay được nghỉ, lên facebook check lịch lại nào!!");
        insert("mail", "Check mail thường xuyên, xem có CTY nào mới đi phỏng vấn không, bạn nhé! ", "Làm bài xong rồi, lên mail nộp bài thôi…", "Hình như không có mail nào mới cả đâu…", "TMA chưa gửi mail cho bạn đâu, hình như mới có mấy cái mail của IT Viec thôi à.");
        insert("web", "Thông tin mà bạn cần tìm đây…", "Cần gì cứ nhắn cho tôi nhé, ba cái này đơn giản á mà…", "Thứ bạn cần tìm kiếm đây…", "Chờ một chút nào, hình như mạng nhà hơi lag…");
        insert("mở", "Ứng dụng của bạn sẽ hiện lên nhanh thôi…", "Mở nó lên nào…", "Chờ một chút nhé, nó lên liền ngay thôi…", "Yêu cầu của bạn sẽ được thực hiện … ngay tức khắc!");
        insert("ngủ", "Nghỉ ngơi một lát cho thoải mái rồi làm việc tiếp sau nào.", "Đi kiếm gì ăn uống rồi quay lại làm việc nhé!", "Nghỉ ngơi thôi !!!", "Ra ngoài chơi xíu nào…");
        insert("tắt máy", "Hôm nay làm việc đủ rồi, nghỉ ngơi đi ngủ thôi.", "Chào tạm biệt, mai lại gọi tôi tới giúp bạn nhé!", "Cảm ơn bạn vì ngày hôm nay, tôi sẽ nhớ bạn <3", "Tạm biệt nhé, hẹn mai gặp lại ;)");
        insert("bạn là ai", "Tôi là i.Sekai, trợ lý ảo cho bạn trong việc dùng máy tính trên hệ điều hành Windows.", "Bạn có thể vào cài đặt, bạn sẽ thấy thông tin về tôi nằm tại đó.", "Tôi là trợ lý ảo của bạn.", "Tôi là phần mềm trợ lý giúp cho bạn được rất nhiều thứ hữu ích!");
        insert("tôi là ai", "Hãy nói tên bạn cho tôi nghe, tôi sẽ ghi nhớ…", "Hình như bạn chưa nói tên bạn cho tôi biết :/", "Tôi không nhớ bạn có nói tên bạn cho tôi nghe…", "Xin lỗi, tôi không, tôi chỉ biết bạn là chủ nhân của tôi.");
        insert("giúp được gì", "Bạn có thể vào cài đặt, xem thông tin của tôi và biết tôi có thể làm gì", "Tôi có thể giúp được bạn rất nhiều thứ…", "Hãy khám phá tôi, rồi bạn sẽ phải thích tôi thôi", "Tôi giúp cho bạn được rất nhiều thứ… bạn có thể tự khám phá ra và sẽ thích tôi…");
        insert("nhớ chưa", "Tôi nhớ rồi", "Tôi đã rõ rồi!", "Tôi nhớ rồi", "Tôi đã rõ rồi!");
        insert("cách sử dụng", "Bạn có thể vào cài đặt, rồi mở phần Guide lên, tôi sẽ hướng dẫn bạn các bước cơ bản để dùng tôi.", "Phần Guide có thể trả lời bạn các câu hỏi đó.", "Hãy đọc hướng dẫn sử dụng trước khi dùng :D :D", "Bạn có thể vào cài đặt, rồi mở phần Guide lên, tôi sẽ hướng dẫn bạn các bước cơ bản để dùng tôi.");
        insert("tên tôi là gì", "Rất xin lỗi, vì tôi chỉ mới được sinh ra từ hôm qua, nên trí nhớ tôi không thể lưu trữ quá nhiều.", "Xin hãy cho tôi thêm thời gian để khắc ghi tên bạn vào tim… (nhưng tôi không có tim thật đâu)", "Rất xin lỗi, vì tôi chỉ mới được sinh ra từ hôm qua, nên trí nhớ tôi không thể lưu trữ quá nhiều.", "Xin hãy cho tôi thêm thời gian để khắc ghi tên bạn vào tim… (nhưng tôi không có tim thật đâu)");
    }

    private static String exceptionCase(String command) {
        if (command.contains("là ai") || command.contains("là gì"))
            if (command.contains("em") || command.contains("bạn") || command.contains("mày"))
                return "bạn là ai";
            else
                return "tôi là gì";
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
