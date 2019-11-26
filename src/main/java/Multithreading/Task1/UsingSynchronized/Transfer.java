package Multithreading.Task1.UsingSynchronized;

public class Transfer implements Runnable {
    private final Account source;
    private final Account destination;
    private double amount;

    public Transfer(Account source, Account destination, double amount) {
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

        Account sourceAccount = null;
        Account destinationAccount = null;

        if (source.getId() > destination.getId()) {
            sourceAccount = source;
            destinationAccount = destination;
        } else {
            sourceAccount = destination;
            destinationAccount = source;
        }

        synchronized (sourceAccount) {
            source.withdraw(amount);
            destination.deposit(amount);
        }
    }
}
