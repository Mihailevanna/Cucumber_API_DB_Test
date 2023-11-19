package Utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Utilities {
    static Connection connection;
    protected static Statement statement;

    @BeforeTest
    public static void DBConnection() {
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        String username = "tester";
        String password = "tester123";


        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

    }

    @AfterTest
    public static void DBConnectionClose() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    public static List<List<String>> getData(String query) {
        List<List<String>> returnList = new ArrayList<>();
        DBConnection();
        try {
            ResultSet rs = statement.executeQuery(query);
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getString(i));
                }
                returnList.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        DBConnectionClose();
        return returnList;
    }
}


