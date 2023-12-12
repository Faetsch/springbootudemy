package de.broccolidev.aopdemo;

import de.broccolidev.aopdemo.dao.AccountDAO;
import de.broccolidev.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {
            demoAfterAdvice(accountDAO, membershipDAO);

        };
    }

    private void demoAfterAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e);
        }
    }

    private void demoAfterThrowingAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e);
        }

    }

    private void demoAfterReturningAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        List<Account> accounts = accountDAO.findAccounts();
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        accountDAO.addAccount(new Account("larry", "5"), true);
        accountDAO.doWork();


        accountDAO.setName("bruh");
        System.out.println(accountDAO.getName());

        membershipDAO.addAccount();
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();
    }
}
