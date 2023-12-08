package config;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {

    @Pointcut("execution(* AOP..*(long))")
    public void publicTarget() {}

}
