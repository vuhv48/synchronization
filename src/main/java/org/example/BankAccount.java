package org.example;

public class BankAccount {
    private double balance;

    private String name;

    private final Object lockName = new Object();
    private final Object lockBalance = new Object();

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public BankAccount(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        synchronized(lockName) {
            this.name = name;
            System.out.println("Updated name to " + name);
        }

    }

    public void deposit(double amount) {
        try {
            System.out.println("Deposit taking to the teller at the bank: ...");
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (lockBalance) {
            double originalBalance = balance;
            balance = balance + amount;
            System.out.println("Starting balance " + originalBalance + " deposit " + amount
                    + " New balance " + balance);
            addPromoDolar(amount);
        }

    }

    public synchronized void withdraw(double amount) {
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

    private void addPromoDolar(double amount) {
        if (amount >= 5000) {
            System.out.println("Congratulations! You have been promoted into the bank!");
            balance += 25;
        }
    }
}
