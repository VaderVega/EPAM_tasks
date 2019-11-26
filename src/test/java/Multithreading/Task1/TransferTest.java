package Multithreading.Task1;

import Multithreading.Task1.UsingSynchronized.Account;
import Multithreading.Task1.UsingSynchronized.Transfer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransferTest {

    double sourceBalance = 1000;
    double destinationBalance = 2000;
    double amount = 100;
    Account source = null;
    Account destination = null;

    @Before
    public void initializeAccounts(){
        source = new Account(sourceBalance);
        destination = new Account(destinationBalance);
    }

    @Test
    public void moneyTransferBetweenDifferentAccounts() throws Exception {
        Thread thread = new Thread(new Transfer(source, destination, amount));

        thread.start();
        thread.join();

        assertEquals(destination.getBalance(), destinationBalance + amount, 0.0);
    }

    @Test
    public void moneyTransferBetweenEqualsAccounts() throws Exception {
        Account destination = source;
        Thread thread = new Thread(new Transfer(source, destination, amount));

        thread.start();
        thread.join();

        assertEquals(destination.getBalance(), sourceBalance, 0.0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwExceptionIfOneOfAccountsIsNull() throws Exception {
        Thread thread = new Thread(new Transfer(source, null, amount));
        thread.start();
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwExceptionIfAmountIsNegative() throws Exception {
        Thread thread = new Thread(new Transfer(source, destination, -500));
        thread.start();
    }

   @Test (expected = IllegalArgumentException.class)
   public void throwExceptionIfSourceDoesntHaveEnoughMoney() {
        Thread thread = new Thread(new Transfer(source, destination, sourceBalance + 100));
        thread.start();
   }
}
