package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DBConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        DataSource ds = new DataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:myoracle");
        ds.setUsername("SPRING6");
        ds.setPassword("_aA123456");

        // 커넥션플 설정
        ds.setInitialSize(2);
        ds.setTestWhileIdle(true);  // 유효 상태 커넷션 객체 체크 여부
        ds.setTimeBetweenEvictionRunsMillis(3000);   // 3초마다 커넥션 상태 체크
        ds.setMinEvictableIdleTimeMillis(30 * 1000);  // 30초가 최대 유효시간 -> 경과시 소멸

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return  new JdbcTemplate(dataSource());
    }
}
