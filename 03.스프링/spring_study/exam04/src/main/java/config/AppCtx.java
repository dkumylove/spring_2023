package config;

import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("models")
public class AppCtx {

    /*
    @Bean
    public MemberDao memberDao(){ //이름이 동일한 경우 수동등록빈이 자동등록빈 보다 우선순위가 높다.
        System.out.println("수동 등록빈");
        return new MemberDao();
    }

     */
}
