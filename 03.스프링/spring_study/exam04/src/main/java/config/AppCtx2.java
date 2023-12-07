package config;

import models.Message;
import models.Message2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtx2 {

    @Bean
    @Scope("prototype") // 객체가 생성될때마다
    public Message message(){
        return  new Message();
    }

    // 인터페이스보다 @Bean을 더 많이 사용함. 매개변수가 있으면 안된다.
    @Bean(initMethod = "init", destroyMethod = "close")
    public Message2 message2() {
        return new Message2();
    }

}
