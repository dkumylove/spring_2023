package jdbctest;

import config.AppCtx;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class JdbcTemplateTest {

    @Autowired
    private DataSource dataSource;

    @Test
    @DisplayName("DataSource를 통한 DB연결 테스트")
    void connectionTest(){
        try (Connection conn = dataSource.getConnection()){
            System.out.println("conn : " + conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
