package org.oop.inheritance;

public class FixedDepositAccount extends Account{
    @Override
    public void deposit() {
        System.out.println("FixedDeposit Account deposits");
    }

    @Override
    public void withdraw() {
        System.out.println("FixedDeposit Account withdrawal");

    }
    @Override
    public void checkBalance() {
        System.out.println("FixedDeposit Account Balance Checker");
    }
}
