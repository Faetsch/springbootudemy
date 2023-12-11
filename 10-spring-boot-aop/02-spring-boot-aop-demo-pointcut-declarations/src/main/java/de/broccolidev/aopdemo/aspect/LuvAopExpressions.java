package de.broccolidev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
    @Pointcut("forDaoPackage() && !getter() && !setter()")
    public void forDaoNoGetterSetter() {}

    @Pointcut("execution (* de.broccolidev.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution (* de.broccolidev.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution (* de.broccolidev.aopdemo.dao.*.set*(..))")
    public void setter() {}

}
