package org.oop.inheritancewithinterfaces;

import java.time.LocalDate;

/*This class demonstrates both abstraction and Encapsulation*/
public abstract class BankAccountImpl implements BankAccountI{
    private String accountId;
    private LocalDate dateCreated;
    private Double balance = 0.0;

    public BankAccountImpl(String accountId, LocalDate dateCreated, Double balance) {
        this.accountId = accountId;
        this.dateCreated = dateCreated;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
