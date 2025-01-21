package org.example;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double originalBalance = balance;
        balance = balance + amount;
        System.out.println("Starting balance " + originalBalance + " deposit " + amount
                + " New balance " + balance);
    }

    public void withdraw(double amount) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double originalBalance = balance;
        if (amount < balance) {
            balance = balance - amount;
            System.out.println("Starting balance " + originalBalance + " withdraw " + amount
                    + " New balance " + balance);
        } else {
            System.out.println("Starting balance " + originalBalance + " withdraw " + amount +
                    "Insufficient balance");
        }

    }
}
