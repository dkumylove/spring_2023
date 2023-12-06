package main;

import config.AppCtx;
import models.member.JoinService;
import models.member.ListService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        JoinService joinService = ctx.getBean("joinService", JoinService.class);
        ListService listService = ctx.getBean("listService", ListService.class);

        ctx.close();
    }
}
