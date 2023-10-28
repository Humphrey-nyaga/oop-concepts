package org.oop;

import org.oop.inheritancewithinterfaces.BankAccountI;
import org.oop.inheritancewithinterfaces.MoneyMarketAccount;
import org.oop.inheritancewithinterfaces.SavingAccount;
import org.oop.inheritancewithoutinterfaces.Account;
import org.oop.inheritancewithoutinterfaces.FixedDepositAccount;
import org.oop.inheritancewithoutinterfaces.SavingsAccount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class App 
{
    public static void main(String[] args) {
        inheritanceWithConcreteClasses();
        inheritanceAndPolymorphismWithAbstractClassAndInterface();

    }

    private static void inheritanceAndPolymorphismWithAbstractClassAndInterface() {
        List<BankAccountI> bankAccountIList = new ArrayList<>();
        bankAccountIList.add(new MoneyMarketAccount("456", LocalDate.now(),9000.0));
        bankAccountIList.add(new SavingAccount("124", LocalDate.now(),50000.0));

        bankAccountIList.forEach(bankAccountI -> bankAccountI.deposit(1000.0));
        bankAccountIList.forEach(bankAccountI -> bankAccountI.withdraw(5000.0));
        bankAccountIList.forEach(BankAccountI::balance);
    }

    private static void inheritanceWithConcreteClasses() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount());
        accounts.add(new FixedDepositAccount());
        accounts.forEach(Account::deposit);
        accounts.forEach(Account::checkBalance);
    }


}
