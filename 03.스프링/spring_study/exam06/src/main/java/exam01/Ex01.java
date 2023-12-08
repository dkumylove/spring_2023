package exam01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 드라이버로딩
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // DB연결 정보
        String url = "jdbc:oracle:thin:@localhost:1521:myoracle";
        String username = "SPRING6";
        String password = "_aA123456";

        Connection conn = null;

        try {
            // DB연결
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // 예외가 발생하든 하지 않든 무조건 실행 : ex) 자원해제
            if (conn != null) {
                try {
                    // 자원해제
                    conn.close();
                } catch (SQLException e2) {
                }
            }
        }
    }
}

