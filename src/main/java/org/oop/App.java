package org.oop;

import org.oop.inheritancewithoutinterfaces.Account;
import org.oop.inheritancewithoutinterfaces.FixedDepositAccount;
import org.oop.inheritancewithoutinterfaces.SavingsAccount;

import java.util.ArrayList;
import java.util.List;


public class App 
{
    public static void main(String[] args) {
        inheritanceWithConcreteClasses();

    }

    private static void inheritanceWithConcreteClasses() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount());
        accounts.add(new FixedDepositAccount());
        accounts.forEach(Account::deposit);
    }

}
