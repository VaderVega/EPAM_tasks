package Multithreading.Task1;

import Multithreading.Task1.UsingSynchronized.AccountInitializer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import java.util.HashMap;
import java.util.Map;

public class AccountInitializerTest {
    File transfersFile = new File("src/test/resources/Multithreading/Task1/transfers.txt");
    Map<Integer, Double> correctValues = new HashMap<>();

    @Before
    public void initMap(){
        correctValues.put(1, 1400.0);
        correctValues.put(2, 900.0);
        correctValues.put(3, 900.0);
        correctValues.put(4, 900.0);
        correctValues.put(5, 900.0);
    }

    @Test
    public void createCorrectOrdersQueue() throws Exception {
        AccountInitializer initializer = new AccountInitializer(transfersFile);

        for (String[] str : initializer.getOrdersQueue())
            assertEquals(3, str.length);
    }

    @Test
    public void checkResults() throws Exception {
        AccountInitializer initializer = new AccountInitializer(transfersFile);
        initializer.initializeAccountsFromFileAndCompleteTransfers();

        Thread.sleep(1000);

        correctValues.forEach((k, v) -> {
            assertEquals(initializer.getAccountBalance(k), v, 0.0);
        });
    }
}
