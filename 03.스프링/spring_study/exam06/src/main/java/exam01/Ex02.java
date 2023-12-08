package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex02 {
    public static void main(String[] args) throws ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:myoracle";
        String username = "SPRING6";
        String password = "_aA123456";

        try (Connection conn = DriverManager.getConnection(url, username, password)){
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
