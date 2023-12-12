package de.broccolidev.aopdemo.aspect;

import de.broccolidev.aopdemo.Account;
import de.broccolidev.aopdemo.dao.AccountDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {


    @After("execution (* de.broccolidev.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        String methodSignature = joinPoint.getSignature().toShortString();
        System.out.println("\n@After (finally) on " + methodSignature);
    }

    @AfterThrowing(pointcut = "execution (* de.broccolidev.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exc")
    public void afterThrowingAccountAdvice(JoinPoint joinPoint, RuntimeException exc) {
        String methodSignature = joinPoint.getSignature().toShortString();
        System.out.println("\n@AfterThrowing on " + methodSignature);
        System.out.println("\nException is " + exc);

    }

    @AfterReturning(pointcut = "execution (* de.broccolidev.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String shortString = joinPoint.getSignature().toShortString();
        System.out.println("\n@AfterReturning on " + shortString);


        //postprocess result
        result.forEach(a -> a.setName(a.getName().toUpperCase()));
        System.out.println("\nresult is " + result);
    }

    @Before("de.broccolidev.aopdemo.aspect.LuvAopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>> Executing @Before Advice");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) {
            System.out.println(tempArg);
            if (tempArg instanceof Account) {
                Account account = (Account) tempArg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }

    }
}
