package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQL {

    public static String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    public static String JDBC = "jdbc:derby:SQL;create=true";
    Connection connection;
    public SQL(){
        try {
            this.connection=DriverManager.getConnection(JDBC);
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void createTable()
    {
        try {
            connection.createStatement().execute("CREATE TABLE MYTABLE(title varchar(50),values1 varchar(500),values2 varchar(500),values3 varchar(500),values4 varchar(500))");
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert(String title,String values1,String values2,String values3,String values4)
    {
        try {
            connection.createStatement().execute("INSERT INTO MYTABLE values('"+title+"','"+values1+"','"+values2+"','"+values3+"','"+values4+"')");
            } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void inserttable()
    {
        insert("error", "Tôi không hiểu ý bạn, bạn có thể hỏi lại chi tiết hơn không? :O", "Rất xin lỗi, yêu cầu của bạn tôi chưa được huấn luyện để thực hiện, xin hãy cho tôi thời gian học hỏi thêm :(","Rất tiếc, tôi chưa được lập trình để thực hiện yêu cầu của bạn, bạn có thể yêu cầu câu lệnh khác ạ. ","Thành thật xin lỗi, tôi không thể thực hiện được câu lệnh của bạn, tôi sẽ đọc thêm sách để hiểu thêm về vấn đề này >_<");
        insert("video", "Thật nhiều video thú vị, bạn chọn một cái và xem nhé!", "Tôi và bạn cùng nhau xem nhé …","Bạn muốn xem video nào về nội dung này nào? Click chọn nhé!","Xem tôi tìm được gì cho bạn nè …");
        insert("hình ảnh", "Kiếm được rồi, hiện hình lên thôi !!", "Thật đẹp, thật dễ thương…", "Bạn muốn tải ảnh về làm ảnh nền hả? Tôi có thể giúp bạn đó", "Nhiều ảnh quá, bạn xem từ từ nhé.");
        insert("nhạc", "Làm việc nhiều rồi, thư giãn một chút thôi…", "Hình như bài này đang là hot trend thì phải?!", "Tôi kiếm ra rồi, mà nhiều bài và ca sĩ khác nhau quá, bạn tự chọn và nghe nhé!", "Bài hát của bạn đây…");
        insert("dịch", "Từ này dễ mà … cơ mà … hmm tôi cũng quên mất rồi, thôi để tra google :D", "Đây, cái nào khó thì mình cứ xài tool ^_^ ", "Từ này nghĩa là … 'con chó con' đó! (Tui đùa đó :v, kết quả dịch đây)", "Úm ba la, ra nghĩa của từ: ");
        insert("bản đồ", "Đi đâu thì nhớ gõ 'Shut down' máy tính rồi hãng đi nhé!", "Đây là chỉ dẫn đường đi từ đây tới đó…", "Đi đâu thì đi, nhớ về nhà ăn tối cùng gia đình, bạn nhé! <3", "Let's go !!!");
        insert("facebook", "Xem có gì 'hot' không nào :/", "Bạn đang tâm trạng hả, có muốn đăng status tâm sự gì không?", "Hmm, lên check xem inbox có ai nhắn tin không nào…", "Hình như hôm nay được nghỉ, lên facebook check lịch lại nào!!");
        insert("mail", "Check mail thường xuyên, xem có CTY nào mới đi phỏng vấn không, bạn nhé! ", "Làm bài xong rồi, lên mail nộp bài thôi…", "Hình như không có mail nào mới cả đâu…", "TMA chưa gửi mail cho bạn đâu, hình như mới có mấy cái mail của IT Viec thôi à.");
        insert("web", "Thông tin mà bạn cần tìm đây…", "Cần gì cứ nhắn cho tôi nhé, ba cái này đơn giản á mà…", "Thứ bạn cần tìm kiếm đây…", "Chờ một chút nào, hình như mạng nhà hơi lag…");
        insert("mở", "Ứng dụng của bạn sẽ hiện lên nhanh thôi…", "Mở nó lên nào…", "Chờ một chút nhé, nó lên liền ngay thôi…", "Yêu cầu của bạn sẽ được thực hiện … ngay tức khắc!");
        insert("sleep", "Nghỉ ngơi một lát cho thoải mái rồi làm việc tiếp sau nào.", "Đi kiếm gì ăn uống rồi quay lại làm việc nhé!", "Nghỉ ngơi thôi !!!", "Ra ngoài chơi xíu nào…");
        insert("shut down", "Hôm nay làm việc đủ rồi, nghỉ ngơi đi ngủ thôi.", "Chào tạm biệt, mai lại gọi tôi tới giúp bạn nhé!", "Cảm ơn bạn vì ngày hôm nay, tôi sẽ nhớ bạn <3", "Tạm biệt nhé, hẹn mai gặp lại ;)");
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
    
    public void update(String title1,String title2,String values1,String values2,String values3,String values4)
    {
        try {
            connection.createStatement().executeUpdate("UPDATE MYTABLE SET title = '"+title2+"', values1 = '"+values1+"', values2 = '"+values2+"', values3 = '"+values3+"', values4 = '"+values4+"' where title = '"+title1+"'");
            } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(String title)
    {
        try {
            connection.createStatement().executeUpdate("DELETE FROM MYTABLE where title = '"+title+"'");
            } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeleteTable()
    {
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
    
   public void print()
   {
        try {
            Statement s = this.connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM MYTABLE");
            while (rs.next()) {                
                System.out.println(rs.getString("title")+" "+rs.getString("values1")+" "+rs.getString("values2")+" "+rs.getString("values3")+" "+rs.getString("values4"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }     
   }
   
   public String error(int num)
   {
       try {
           
           String answer;
            if (num%4 == 0)
            {
                answer = "values1";
            }
            else if(num%3 == 0)
            {
                answer = "values2";
            }
            else if(num%2 == 0)
            {
                answer = "values3";
            }
            else 
            {
                answer = "values4";
            }
            Statement s = this.connection.createStatement();
            String query = "SELECT "+answer+" FROM MYTABLE where title like '%error%'";
            ResultSet rs;
            rs = s.executeQuery(query);
            if (rs.next()) {         

                 return rs.getString(answer);
            }
       } catch (Exception e) {
       }
       return null;
   }
   
    public String check(String title)
    {
        char arr[]= title.toCharArray();
        int n= arr.length;
        if (title=="shut down"||title=="hình ảnh"||title=="bạn là ai"||title=="mày là ai"||title=="biết tôi là ai không"||title=="biết tao là ai không"||title=="mày giúp được gì cho tao"||title=="bạn giúp được gì cho tôi"||title=="tên tôi là gì"||title=="tên tao là gì"||title=="bản đồ")
        {
            return title;
        }
        else 
        {
            for (int i=0;i<n;i++)
            {
                if (arr[i] == 32)
                {                               
                    return String.copyValueOf(arr, 0, i);                    
                }
                if ((i==n-1 && arr[i]!=32))
                {
                    return title;
                }
            }
        }
        return null;
    }
    public String getanswer(String titleString,int num)
    {
        String title = check(titleString);
        try {
            
            String answer;
            if (num%4 == 0)
            {
                answer = "values1";
            }
            else if(num%3 == 0)
            {
                answer = "values2";
            }
            else if(num%2 == 0)
            {
                answer = "values3";
            }
            else 
            {
                answer = "values4";
            }
            
            Statement s = this.connection.createStatement();
            String query = "SELECT "+answer+" FROM MYTABLE where title like '%"+title+"%'";
            ResultSet rs;
            rs = s.executeQuery(query);
            if (rs.next()) {         

                return rs.getString(answer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        num++;
        return error(num);
    }
}
