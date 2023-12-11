package de.broccolidev.aopdemo.dao;

import de.broccolidev.aopdemo.Account;
import org.springframework.stereotype.Repository;

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
}
