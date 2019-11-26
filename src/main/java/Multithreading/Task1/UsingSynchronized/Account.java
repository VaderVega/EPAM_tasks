package Multithreading.Task1.UsingSynchronized;

import java.util.Objects;

public class Account {
    public static volatile long initID = 1;

    private final long id;
    private double balance;

    public Account(double balance) {
        this.balance = balance;
        this.id = initID++;
    }

    public void deposit(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Wrong amount value. Amount can't be negative.");

        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Wrong amount value. Amount can't be negative.");

        if (amount > balance)
            throw new IllegalArgumentException(String.format("Insufficient funds in account with ID %d. Current balance: %.2f. Requested money: %.2f", id, balance, amount));

        balance -= amount;
    }

    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
