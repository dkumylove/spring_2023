package jdbctest;

import config.AppCtx;
import models.member.Member;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class JdbcTemplateTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("DataSource를 통한 DB연결 테스트")
    void connectionTest(){
        try (Connection conn = dataSource.getConnection()){
            System.out.println("conn : " + conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("INSERT테스트")
    void insertTest() {
        //DataAccessException - RuntimeException - 예외처리 x -> 실행
        String sql = "INSERT INTO MEMBER(USER_NO, USER_ID, USER_PW, USER_NM, EMAIL) VALUES(SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?)";

        int affectedRows = jdbcTemplate.update(sql, "USER100", "123456", "사용자100", "user100@test.org");
        System.out.println(affectedRows);
    }

    @Test
    @DisplayName("INSERT 후 시퀀스 번호 추출")
    void insertTest2() {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int affectedRows = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, EMAIL) VALUES (SEQ_MEMBER.nextval, ?, ?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"USER_NO"});

                pstmt.setString(1, "USER199");
                pstmt.setString(2, "123456");
                pstmt.setString(3, "사용자199");
                pstmt.setString(4, "user199@test.org");

                return pstmt;
            }
        }, keyHolder);

        long userNo = keyHolder.getKey().longValue();
        System.out.println("userNo : " + userNo);
    }

    @Test
    @DisplayName("목록출력테스트")
    void selectTest() {
        String sql = "SELECT * FROM MEMBER";
        List<Member> members = jdbcTemplate.query(sql, this::mapper);

        for (Member member : members) {
            System.out.println(member);
        }
    }

    private Member mapper(ResultSet rs, int i) throws SQLException {
        return Member.builder().userNo(rs.getLong("USER_NO"))
                .userId(rs.getString("USER_ID"))
                .userPw(rs.getString("USER_PW"))
                .userNm(rs.getString("USER_NM"))
                .email(rs.getString("EMAIL"))
                .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                .build();
    }


}
