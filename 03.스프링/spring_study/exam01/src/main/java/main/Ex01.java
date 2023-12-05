package main;

import config.AppCtx;
import models.Greeter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        // 에노테이션설정방식의 에플리케이션 컨테이너(스프링컨테이너)
        // (AppCtx.class) AppCtx(설정클래스)의 클래스 정보가 매게 변수로 옴
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        g1.hello("name");

        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        System.out.println(g1 == g2);

        ctx.close();
    }
}
