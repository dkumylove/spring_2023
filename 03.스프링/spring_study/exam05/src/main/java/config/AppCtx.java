package config;

import AOP.Calculator;
import AOP.RecCalculator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    public Calculator calculator(){
        return new RecCalculator();
    }
}
