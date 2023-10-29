package org.oop.inheritancewithinterfaces;

import org.oop.inheritancewithinterfaces.interfaces.CFDInterestI;
import org.oop.inheritancewithinterfaces.interfaces.CFDMaturityI;
import org.oop.inheritancewithinterfaces.interfaces.CertificateOfDepositI;

import java.time.LocalDate;
import java.time.Period;

public class CertificateOfDepositAccount implements CertificateOfDepositI, CFDInterestI, CFDMaturityI {

    private final int CFDMaturityPeriodInYears;
    private final LocalDate subscriptionDate;
    private final Double principal;
    private final Double annualInterestRate;
    private final Double PENALTY_ON_EARLY_EXIT = 0.40; // 40% of interest earned

    public CertificateOfDepositAccount(int CFDMaturityPeriodInYears, LocalDate subscriptionDate, Double principal, double annualInterestRate) {
        this.CFDMaturityPeriodInYears = CFDMaturityPeriodInYears;
        this.subscriptionDate = subscriptionDate;
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public Double getPrincipal() {
        return principal;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    @Override
    public LocalDate getMaturityDate() {
        return subscriptionDate.plusYears(CFDMaturityPeriodInYears);
    }

    @Override
    public void withdrawMaturedAmount() {

        if (IsMaturedCFD()) {
            System.out.println("***Matured CFD***");
            Period period = Period.between(subscriptionDate, getMaturityDate());
            int years = period.getYears();
            double interest =  calculateCFDInterest(years, getPrincipal(), getAnnualInterestRate());
            System.out.println("Principal Amount: " + getPrincipal());
            System.out.println("Interest Earned: " + interest);
            System.out.println("Total Amount Payable:  "+ interest + getPrincipal());
        } else {
            System.out.println("Certificate of Deposit: Not yet Mature");
        }
    }


    @Override
    public void withdrawPreMaturedAmount() {
        if (!IsMaturedCFD()) {
            System.out.println("\n**Immature CFD**");
            Period period = Period.between(getSubscriptionDate(), LocalDate.now());
            int years = period.getYears();
            double interest =  calculateCFDInterest(years, getPrincipal(), getAnnualInterestRate());
            double penalty = PENALTY_ON_EARLY_EXIT * interest;
            double interestAfterPenalty = interest - penalty;
            double payableAmount = getPrincipal() + interestAfterPenalty;

            System.out.println("Principal Amount: " + getPrincipal());
            System.out.println("Total Interest Earned: " + interest);
            System.out.println("Penalty: " + penalty);
            System.out.println("Net Interest After Penalty: " + interestAfterPenalty);
            System.out.println("Total Amount Payable: " + payableAmount);
        }
    }

    @Override
    public boolean IsMaturedCFD() {
        return LocalDate.now().isAfter(getMaturityDate());
    }

    @Override
    public double calculateCFDInterest(int years, double principal, double annualInterestRate) {
        double semiAnnualRate = annualInterestRate / 2;
        int semiAnnualPeriods = years * 2;
        return principal * (Math.pow(1 + semiAnnualRate / 100, semiAnnualPeriods)) - principal;
    }
}
