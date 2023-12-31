package config;

import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/*@ComponentScan(value = "models", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ManualBean.class))*/
/*@ComponentScan(value = "models", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class))*/
@ComponentScan(value = "models", excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "models..*Dao"))//.. 하위패키지를 포함한 모든 패키지
public class AppCtx {

    /*
    @Bean
    public MemberDao memberDao(){ //이름이 동일한 경우 수동등록빈이 자동등록빈 보다 우선순위가 높다.
        System.out.println("수동 등록빈");
        return new MemberDao();
    }

     */
}
