package org.oop.inheritancewithinterfaces;

import org.oop.inheritancewithinterfaces.interfaces.CFDInterestI;
import org.oop.inheritancewithinterfaces.interfaces.CertificateOfDepositI;

import java.time.LocalDate;
import java.time.Period;

public class CertificateOfDepositAccount implements CertificateOfDepositI, CFDInterestI {

    private Long CFDMaturityPeriodInYears;
    private LocalDate subscriptionDate;
    private Double principal;
    private double annualInterestRate;
    private final Double PENALTY_ON_EARLY_EXIT = 0.40; // 40% of interest earned

    @Override
    public LocalDate getMaturityDate() {
        return subscriptionDate.plusYears(CFDMaturityPeriodInYears);
    }

    @Override
    public void withdrawMaturedAmount() {

        if (LocalDate.now().isAfter(getMaturityDate())) {
            Period period = Period.between(subscriptionDate, getMaturityDate());
            int months = (period.getYears() * 12) + period.getMonths();
            double principalPlusInterest = calculateCFDInterest(months,principal,annualInterestRate);
            System.out.println("Principal plus Interest " + principalPlusInterest);
        }
        else {
            System.out.println("Certificate of Deposit: Not yet Mature");
        }
    }


    @Override
    public void withdrawPreMaturedAmount() {
        if (LocalDate.now().isBefore(getMaturityDate())) {
            Period period = Period.between(subscriptionDate, LocalDate.now());
            int months = (period.getYears() * 12) + period.getMonths();
            double principalPlusInterest = calculateCFDInterest(months,principal,annualInterestRate);
            double interestBeforePenalty  = principalPlusInterest - principal;
            double penalty = PENALTY_ON_EARLY_EXIT * interestBeforePenalty;
            double interestAfterPenalty = interestBeforePenalty - penalty;
            double payableAmount = principal + interestAfterPenalty;

            System.out.println("Principal Amount: " + principal );
            System.out.println("Total Interest Earned: " + interestBeforePenalty );
            System.out.println("Penalty: " + penalty );
            System.out.println("Net Interest Accrued: " + interestAfterPenalty );
            System.out.println("Total Amount Payable: " + (payableAmount));
        }
    }

    @Override
    public double calculateCFDInterest(int months, double principal, double annualInterestRate) {
        double monthlyInterestRate = annualInterestRate / 12;
        return principal * Math.pow(1 + monthlyInterestRate, months);

    }


}
