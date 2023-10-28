package org.oop.inheritancewithinterfaces;

import java.time.LocalDate;

public class CertificateOfDepositAccount implements CertificateOfDepositI, SavingsInterestI,BankAccountI {


    @Override
    public void deposit() {

    }

    @Override
    public void balance() {

    }

    @Override
    public LocalDate getMaturityDate() {
        return null;
    }

    @Override
    public void withdrawMaturedAmount() {

    }

    @Override
    public void earlyWithdrawalPenalty() {

    }

    @Override
    public void withdrawPreMaturedAmount() {

    }

    @Override
    public void calculateInterest(Double interestRate) {

    }
}
