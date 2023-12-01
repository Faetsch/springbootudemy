package de.broccolidev.aopdemo.dao;

import de.broccolidev.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}
