package Database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public abstract class SQL {

    protected static Connection connection;
    private static final JSONParser parser = new JSONParser();
    private static int count = 0;

    public static void createTable() {
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {}
        } catch (ClassNotFoundException ex) {}
        try {
            connection.createStatement().execute("CREATE TABLE MYTABLE(title varchar(50),values1 varchar(500),values2 varchar(500),values3 varchar(500),values4 varchar(500))");
        } catch (SQLException ex) {}
        
    }

    public static void insert(String title, String values1, String values2, String values3, String values4) {
        try {
            connection.createStatement().execute("INSERT INTO MYTABLE values('" + title + "','" + values1 + "','" + values2 + "','" + values3 + "','" + values4 + "')");
        } catch (SQLException ex) {}
    }

    public static String checkAnswer(String command, String languge) {
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new InputStreamReader(SQL.class.getResourceAsStream("/Database/Keyword.json")));
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;  
                String keyword = (String) jsonObject.get(languge);
                if (command.contains(keyword)) {
                    return keyword;
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {}
        return command;
    }


    public static String getValue(SQL sql, String title) {
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
        try {
            Statement statement = sql.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT " + answer + " FROM MYTABLE where title like '%" + title + "%'");
            if (resultSet.next()) {
                return resultSet.getString(answer);
            }
            resultSet = statement.executeQuery("SELECT " + answer + " FROM MYTABLE where title like '%error%'");
            if (resultSet.next()) {
                return resultSet.getString(answer);
            }
        } catch (SQLException e) {}
        return null;
    }
}
