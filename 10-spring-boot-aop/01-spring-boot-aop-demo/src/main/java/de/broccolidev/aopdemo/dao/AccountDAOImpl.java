package de.broccolidev.aopdemo.dao;

import de.broccolidev.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": <DB WORK: ADDING GENERIC ACCOUNT>");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": <DB WORK: DOING WORK>");
        return false;
    }
}
