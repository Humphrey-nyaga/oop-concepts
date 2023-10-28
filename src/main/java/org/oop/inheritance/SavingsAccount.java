package org.oop.inheritance;

public class SavingsAccount extends Account  {
    @Override
    public void deposit() {
        System.out.println("Savings Account deposit");
    }

    @Override
    public void withdraw() {
        System.out.println("Savings Account withdrawal");

    }

    @Override
    public void checkBalance() {
        System.out.println("Savings Account Balance Checker");
    }

}
