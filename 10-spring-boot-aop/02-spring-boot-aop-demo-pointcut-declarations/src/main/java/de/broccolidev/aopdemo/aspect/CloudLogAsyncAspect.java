package de.broccolidev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsyncAspect {


    @Before("de.broccolidev.aopdemo.aspect.LuvAopExpressions.forDaoNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n====> CLOUD ASYNC");
    }
}
