package org.oop.inheritancewithinterfaces;

import org.oop.inheritancewithinterfaces.interfaces.BankAccountI;

import java.time.LocalDate;

public class SavingAccount extends Account implements BankAccountI {
    private final Double MINIMUM_DEPOSIT = 100.0;

    public SavingAccount(String accountId, LocalDate dateCreated, Double balance) {
        super(accountId, dateCreated, balance);
    }

    @Override
    public void accountId() {
        System.out.println("Account ID: " + getAccountId());
    }

    @Override
    public void deposit(Double amount) {
        if (amount >= MINIMUM_DEPOSIT) {
            setBalance(getBalance() + amount);
            System.out.println("Deposit of Ksh " + amount + " to Savings Account successful. " +
                    "\t Current balance:  " + getBalance());
        } else {
            System.out.println("Minimum deposit of Ksh " + MINIMUM_DEPOSIT + " Required");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Insufficient Balance");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Savings Account Withdrawal of: " + amount + " completed ");
        }
    }

    @Override
    public void balance() {
        System.out.println("Saving Account Balance: " + getBalance());
    }

    @Override
    public void calculateInterest(Double interestRate) {

        if (getBalance() != 0 && interestRate > 0) {
            double simpleInterest = getBalance() * (interestRate / 100.0);
            System.out.println(" Savings Account Interest: " + simpleInterest);
        } else {
            System.out.println("Interest could not be determined. Try Again");
        }
    }
}
