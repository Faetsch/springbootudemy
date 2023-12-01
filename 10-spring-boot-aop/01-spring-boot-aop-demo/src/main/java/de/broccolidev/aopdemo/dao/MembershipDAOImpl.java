package de.broccolidev.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": <DB WORK: ADDING MEMBERSHIP ACCOUNT>");
    }

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + ": <DB WORK: ADDING SILLY MEMBER>");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": SLEEP");
    }
}
