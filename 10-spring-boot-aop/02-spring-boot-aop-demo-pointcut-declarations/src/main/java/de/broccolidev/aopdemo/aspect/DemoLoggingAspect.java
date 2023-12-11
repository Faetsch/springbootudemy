package de.broccolidev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>> Executing @Before Advice");
    }


    @Before("forDaoNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n====> API ANALYTICS");
    }

    @Pointcut("forDaoPackage() && !getter() && !setter()")
    public void forDaoNoGetterSetter() {}

    @Pointcut("execution (* de.broccolidev.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution (* de.broccolidev.aopdemo.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution (* de.broccolidev.aopdemo.dao.*.set*(..))")
    private void setter() {}

}
