package de.broccolidev.aopdemo.dao;

import de.broccolidev.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

    List<Account> findAccounts(boolean tripWire);
    List<Account> findAccounts();
}
