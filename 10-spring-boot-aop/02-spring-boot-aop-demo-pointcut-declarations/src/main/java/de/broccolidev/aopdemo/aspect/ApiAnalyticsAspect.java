package de.broccolidev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

    @Before("de.broccolidev.aopdemo.aspect.LuvAopExpressions.forDaoNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n====> API ANALYTICS");
    }
}
