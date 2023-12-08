package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class ProxyCalculator {
    /*
    @Pointcut("execution(* AOP..*(..))")
    public void publicTarget() {}

    // 범용적으로 사용되는 것이기 때문에 반환값이 어떤게 나올지 모르기떄문에 Object
    @Around("publicTarget()")*/
    //@Around("execution(* AOP..*(..))")
    @Around("config.CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        //System.out.println("프로시");

//        Signature sig = joinPoint.getSignature();
//        System.out.println(sig.toLongString());

        Object[] args = joinPoint.getArgs();
        long num = (long)args[0];
        System.out.println(num);

        long stime = System.nanoTime();  // 공통기능
        try {
            Object result = joinPoint.proceed();    // 핵심 기능을 대신 수행하는 메서드
            // factorial(..)

            return result;
        } finally {
            long etime = System.nanoTime(); // 공통기능
            System.out.printf("걸린시간 : %ds%n", etime - stime);
        }

    }
}
