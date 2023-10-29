package org.oop;

import org.oop.inheritancewithinterfaces.CertificateOfDepositAccount;
import org.oop.inheritancewithinterfaces.interfaces.BankAccountI;
import org.oop.inheritancewithinterfaces.MoneyMarketAccount;
import org.oop.inheritancewithinterfaces.SavingAccount;
import org.oop.inheritance.Account;
import org.oop.inheritance.FixedDepositAccount;
import org.oop.inheritance.SavingsAccount;
import org.oop.inheritancewithinterfaces.interfaces.CertificateOfDepositI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        inheritanceWithConcreteClasses();
        inheritanceAndPolymorphismWithAbstractClassAndInterface();
        encapsulationAndPolymorphismWithInterfaces();

    }

    private static void encapsulationAndPolymorphismWithInterfaces() {
        System.out.println("\n******ENCAPSULATION AND POLYMORPHISM WITH INTERFACES ONLY******");

        List<CertificateOfDepositI> CDAccounts = List.of(
                new CertificateOfDepositAccount(10, LocalDate.of(2012, 12, 10), 100_000.0, 14.0),
                new CertificateOfDepositAccount(6, LocalDate.of(2018, 12, 10), 100_000.0, 14.0));

        CDAccounts.forEach(CertificateOfDepositI::getMaturityDate);

        CDAccounts.get(0).withdrawMaturedAmount();
        CDAccounts.get(1).withdrawPreMaturedAmount();

    }

    private static void inheritanceAndPolymorphismWithAbstractClassAndInterface() {
        System.out.println("\n******INHERITANCE WITH ABSTRACT CLASSES AND INTERFACES******");
        List<BankAccountI> bankAccountIList = new ArrayList<>();
        MoneyMarketAccount moneyMarketAccount = new MoneyMarketAccount("456", LocalDate.of(2022, 6, 12), 9000.0);
        SavingAccount savingAccount = new SavingAccount("124", LocalDate.of(2022, 6, 12), 50000.0);
        bankAccountIList.add(moneyMarketAccount);
        bankAccountIList.add(savingAccount);

        bankAccountIList
                .forEach(bankAccountI -> {
                    System.out.println();
                    bankAccountI.accountId();
                    bankAccountI.deposit(1000.0);
                    bankAccountI.withdraw(5000.0);
                    bankAccountI.balance();
                    bankAccountI.calculateInterest(9.0);
                });
    }

    private static void inheritanceWithConcreteClasses() {
        System.out.println("******INHERITANCE WITH CONCRETE CLASSES******");
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount());
        accounts.add(new FixedDepositAccount());
        accounts.forEach(Account::deposit);
        accounts.forEach(Account::checkBalance);
        accounts.forEach(Account::withdraw);
    }


}
