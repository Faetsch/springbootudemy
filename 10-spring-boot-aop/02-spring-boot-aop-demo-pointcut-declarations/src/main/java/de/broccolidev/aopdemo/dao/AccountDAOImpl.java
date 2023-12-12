package de.broccolidev.aopdemo.dao;

import de.broccolidev.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": <DB WORK: ADDING GENERIC ACCOUNT>");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": <DB WORK: DOING WORK>");
        return false;
    }


    public String getName() {
        System.out.println(getClass() + ": IN GETTER");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": IN SETTER");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": IN GETTER");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": IN SETTER");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts(boolean tripWire){
        if(tripWire) {
            throw new RuntimeException("simulating exception");
        }
        ArrayList<Account> accounts = new ArrayList<>();
        Account account1 = new Account("Larry", "A");
        Account account2 = new Account("Michael", "B");
        Account account3 = new Account("Jim", "C");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        return accounts;
    }

    @Override
    public List<Account> findAccounts(){
        return findAccounts(false);
    }
}
