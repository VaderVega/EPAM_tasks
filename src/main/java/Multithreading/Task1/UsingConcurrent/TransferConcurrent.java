package Multithreading.Task1.UsingConcurrent;

import Multithreading.Task1.UsingSynchronized.Account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransferConcurrent implements Runnable{
    private final Account source;
    private final Account destination;
    private final double amount;
    private static final Lock lock = new ReentrantLock();

    public TransferConcurrent(Account source, Account destination, double amount) {
        if (source == null || destination == null)
            throw new IllegalArgumentException("Wrong values. Source or destination account can't be null.");


        if (amount < 0)
            throw new IllegalArgumentException("Amount must be positive. Current amount: " + amount);

        if (amount > source.getBalance())
            throw new IllegalArgumentException(String.format(
                    "Insufficient funds in account with ID %d. Current balance: %.2f. Requested money: %.2f",
                    source.getId(), source.getBalance(), amount));


        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (source.equals(destination) || amount == 0)
            return;

        lock.lock();

        source.withdraw(amount);
        destination.deposit(amount);
    }
}
