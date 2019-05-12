/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sy Nguyen
 */
public class SQL {
    public static String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
    public static String JDBC = "jdbc:derby:java;create=true";
    Connection connection;
    private String k = "key";
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
            connection.createStatement().execute("CREATE TABLE MYTABLE(k varchar(50),values1 varchar(100),values2 varchar(100))");
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert(String k,String an1,String an2)
    {
        try {
            connection.createStatement().execute("INSERT INTO MYTABLE values('"+k+"','"+an1+"','"+an2+"')");
            } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void inserttable()
    {
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
    
    public void update(String key1,String key2,String values1,String values2)
    {
        try {
            connection.createStatement().executeUpdate("UPDATE MYTABLE SET k = '"+key2+"', values1 = '"+values1+"', values2 = '"+values2+"' where k = '"+key1+"'");
            } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(String key)
    {
        try {
            connection.createStatement().executeUpdate("DELETE FROM MYTABLE where k = '"+key+"'");
            } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeleteTable()
    {
        delete("anime");
        delete("face");
        delete("jam");
        delete("lmss");
        delete("lol");
        delete("map");
        delete("music");
        delete("picture");
        delete("se");
        delete("translate");
        delete("video");
        delete("web");
        delete("go to sleep");
        delete("open excel");
        delete("open powerpoint");
        delete("open word");
        delete("shut down");
    }
    
   public void print()
   {
        try {
            Statement s = this.connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM MYTABLE");
            while (rs.next()) {                
                System.out.println(rs.getString("k")+" "+rs.getString("an1")+" "+rs.getString("an2"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }     
   }
    public String check(String key)
    {
        char arr[]= key.toCharArray();
        int n= arr.length;
        if (key=="shut down"||key=="shut down"||key=="open word"||key=="open excel"||key=="open powerpoint"||key=="go to sleep")
        {
            return key;
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
                    return key;
                }
            }
        }
        return null;
    }
    public String getanswer(String keyString,int i)
    {
        String key = check(keyString);
        try {
            
            String answer;
            if (i%2 != 0)
            {
                answer = "values1";
            }
            else 
            {
                answer = "values2";
            }
            
            Statement s = this.connection.createStatement();
            String query = "SELECT "+answer+" FROM MYTABLE where k like '%"+key+"%'";
            ResultSet rs;
            rs = s.executeQuery(query);
            if (rs.next()) {         

                return rs.getString(answer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}
