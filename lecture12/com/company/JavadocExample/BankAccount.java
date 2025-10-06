package com.company.JavadocExample;
/**
 * Represents a simple bank account with basic operations.
 * 
 * @author Alberto Castro Hernandez
 * @version 1.0
 * @since 2025-10-05
 */
public class BankAccount {
    private String accountHolder;
    private double balance;

    /**
     * Constructs a BankAccount with the specified account holder and initial balance.
     *
     * @param accountHolder the name of the account holder
     * @param initialBalance the starting balance of the account
     */
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    /**
     * Deposits a specified amount into the account.
     *
     * @param amount the amount to deposit
     * @return the new balance after deposit
     */
    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    /**
     * Withdraws a specified amount from the account.
     *
     * @param amount the amount to withdraw
     * @return the new balance after withdrawal
     * @throws IllegalArgumentException if the amount exceeds the current balance
     */
    public double withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
        return balance;
    }

    /**
     * Returns the current balance of the account.
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }
}