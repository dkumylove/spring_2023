package main;

import config.AppCtx2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
    public static void main(String[] args) {
        // 객체 생성, 의존 설정, 초기화(afterPropertiesSet 호출)
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);

        ctx.close(); // 컨테이너 소멸 -> 이전에 destroy() 호출

    }
}
