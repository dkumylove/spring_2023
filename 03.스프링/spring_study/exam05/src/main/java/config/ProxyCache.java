package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(1)
public class ProxyCache {

    private Map<Long, Object> cachDate = new HashMap<>();

    @Around("config.CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable{

        Object[] args = joinPoint.getArgs();  // 매개변수로 투입된 인자 값 (ex - 10L)
        Long num = (long)args[0];
        if(cachDate.containsKey(num)){
            System.out.println("캐시값 사용");
            return cachDate.get(num);
        }

        Object result = joinPoint.proceed();   // ProxyCalculator::proceed()

        // 캐시저장
        cachDate.put(num, result);
        System.out.println("캐시저장");

        return result;

    }
}
