package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class ProxyCache {

    private Map<Long, Long> cachDate = new HashMap<>();

    @Pointcut("execution(* AOP..*(long))")
    public void publicTarget() {}

    @Around("publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable{

        Object[] args = joinPoint.getArgs();  // 매개변수로 투입된 인자 값 (ex - 10L)
        Long num = (long)args[0];
        if(cachDate.containsKey(num)){
            return cachDate.get(num);
        }

        Object result = joinPoint.proceed();

        return result;

    }
}
