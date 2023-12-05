package config;

import models.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정클래스임을 명시
public class AppCtx {
    @Bean // 관리할 객체임을 명시
    public Greeter greeter() {
        return new Greeter();
    }

}
