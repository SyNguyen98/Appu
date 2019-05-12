package Command;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {

    static int count = 0;
    public static String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    public static String JDBC = "jdbc:derby:java;create=true";
    Connection connection;

    public SQL() {
        try {
            this.connection = DriverManager.getConnection(JDBC);
        } catch (SQLException ex) {}
    }

    public void createTable() {
        try {
            connection.createStatement().execute("CREATE TABLE MYTABLE(k varchar(50),an1 varchar(100),an2 varchar(100))");
        } catch (SQLException ex) {}
    }

    public void insert(String k, String an1, String an2) {
        try {
            connection.createStatement().execute("INSERT INTO MYTABLE values('" + k + "','" + an1 + "','" + an2 + "')");
        } catch (SQLException ex) {}
    }

    public void inserttable() {
        insert("anime", "ANIME DAISUKI", "coi phim thôi");
        insert("face", "FACE TIME", "không biết hôm nay có gì nè");
        insert("jam", "chủ nhân định đi đâu thế", "ngài muốn đi đâu ah");
        insert("lmss", "ra nè", "nó nè");
        insert("lol", "đang kiếm . . . có rồi", "người mà master kiếm nè");
        insert("map", "chúng ta đang ở đâu thế master ", "đây là đâu ?");
        insert("music", "nghe nhạc sao em thích nghe nhạc lắm đó", "mở nhạc lên");
        insert("picture", "đang mở hình ảnh", "hình ảnh hiện lên");
        insert("se", "em báo với anh CAN đó", "HENTAI !! BAKA !! ECCHI");
        insert("translate", "master muốn em dịch từ gì ", "có vậy cũng không biết để em dịch cho");
        insert("video", "video đang mở", "master đang xem gì thế?");
        insert("web", "master đang kiếm gì vậy ?", "nảo em đang load master chờ xí");
        insert("go to sleep", "ZzzzZzzzZ", "chúc ngủ ngon chủ nhân");
        insert("open excel", "EXCEL MỞ RA", "EXCEL THẲNG TIẾN");
        insert("open powerpoint", "PowerPoint let''s go", "PowerPoint đã rỏ");
        insert("open word", "OPEN WORD", "đã rõ master");
        insert("shut down", "bye bye", "ngài vất vả rồi");
    }

    public String check(String k) {
        char arr[] = k.toCharArray();
        int n = arr.length;
        if (k == "shut down" || k == "shut down" || k == "open word" || k == "open excel" || k == "open powerpoint" || k == "go to sleep") {
            return k;
        } else {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 32) {
                    return String.copyValueOf(arr, 0, i);
                }
                if ((i == n - 1 && arr[i] != 32)) {
                    return k;
                }
            }
        }
        return null;
    }

    public String getAnswer(String command) {
        String key = check(command);
        try {
            String answer;
            if (count++ % 2 == 0) {
                answer = "an1";
            } else {
                answer = "an2";
            }
            Statement statement = this.connection.createStatement();
            String query = "SELECT " + answer + " FROM MYTABLE where k like '%" + key + "%'";
            ResultSet resultSet;
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getString(answer);
            }
        } catch (Exception e) {}
        return "error";
    }
}
