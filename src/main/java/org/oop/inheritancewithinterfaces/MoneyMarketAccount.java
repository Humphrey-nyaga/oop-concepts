package org.oop.inheritancewithinterfaces;

import org.oop.inheritancewithinterfaces.interfaces.SavingsInterestI;

import java.time.LocalDate;
import java.time.Period;

public class MoneyMarketAccount extends BankAccountImpl implements SavingsInterestI {

    private final Double MINIMUM_DEPOSIT = 1000.0;
    private final Double MINIMUM_INITIAL_INVESTMENT_AMOUNT = 5000.0;
    private final Integer WITHDRAWAL_SETTLEMENT_DAYS = 2;
    private  LocalDate withdrawalSettlementDate;
    public MoneyMarketAccount(String accountId, LocalDate dateCreated, Double OpeningBalance) {
        super(accountId, dateCreated, OpeningBalance);
        withdrawalSettlementDate = null;
        if ( OpeningBalance < MINIMUM_INITIAL_INVESTMENT_AMOUNT) {
            throw new IllegalArgumentException("Creating an MMF account requires minimum of "+ MINIMUM_INITIAL_INVESTMENT_AMOUNT);
        }
    }

    @Override
    public void deposit(Double amount) {

        if (amount < MINIMUM_DEPOSIT){
            System.out.println("Minimum deposit to MMF Account is Ksh: "+ MINIMUM_DEPOSIT);
        } else {
            setBalance( MINIMUM_DEPOSIT + getBalance());
            System.out.println("Successful Deposit of Ksh " + amount + " to MMF Account." +
                    " \t Current Balance Is Ksh " + getBalance());
        }
    }

    @Override
    public void balance() {
        System.out.println("Current MMF Account Balance Is: " + getBalance());
    }

    @Override
    public void calculateInterest(Double interestRate) {

        Period period = Period.between(getDateCreated(), LocalDate.now());
        int months = period.getYears() * 12 + period.getMonths();
        double monthlyInterestRate = interestRate / 12;
        double interestPlusPrincipal = getBalance() * Math.pow(1 + monthlyInterestRate, months);
        double interest = interestPlusPrincipal - getBalance();
        System.out.println("MMF Account Interest Earned: " + interest);
    }

    @Override
    public void withdraw(double amount) {

        if (withdrawalSettlementDate != null && LocalDate.now().isBefore(withdrawalSettlementDate)) {
            System.out.println("You have a pending Withdrawal Request.");
            return;
        }
        if (amount > getBalance()) {
            System.out.println("MMF Account: Insufficient Balance.");
        } else {
            setBalance(getBalance() - amount);
            withdrawalSettlementDate = LocalDate.now().plusDays(2);
            System.out.println("MMF Account: Withdrawal of: " + amount + " initiated." +
                    " \tSettlement to be completed in " +WITHDRAWAL_SETTLEMENT_DAYS + " days" );
        }

    }
}