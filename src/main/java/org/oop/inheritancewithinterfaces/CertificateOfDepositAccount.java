package org.oop.inheritancewithinterfaces;

import java.time.LocalDate;

public class CertificateOfDepositAccount implements CertificateOfDepositI, SavingsInterestI {


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
