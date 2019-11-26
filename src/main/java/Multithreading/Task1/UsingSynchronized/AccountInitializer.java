package Multithreading.Task1.UsingSynchronized;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AccountInitializer {
    double defaultBalance = 1000;
    Deque<String[]> orders = new LinkedList<>();
    Map<Integer, Account> accounts = new HashMap<>();

    public AccountInitializer(File file) {
        if (file == null || !file.exists())
            throw  new IllegalArgumentException("File doesn't exist.");

        readFile(file);
    }

    private void readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String readingStr = "";

            while ((readingStr = reader.readLine()) != null) {
                String[] tmp = readingStr.split(",");
                if (tmp.length == 3 && Double.parseDouble(tmp[0]) > 0 &&
                Double.parseDouble(tmp[1]) > 0)
                    orders.add(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void initializeAccountsFromFileAndCompleteTransfers() {
        while (!orders.isEmpty()) {
            String[] str = orders.poll();

            int sourceID = Integer.parseInt(str[0]);
            int destinationID = Integer.parseInt(str[1]);
            double amount = Double.parseDouble(str[2]);

            if (!accounts.containsKey(sourceID)) {
                accounts.put(sourceID, new Account(defaultBalance));
            }

            if (!accounts.containsKey(destinationID)) {
                accounts.put(destinationID, new Account(defaultBalance));
            }

            Thread thread = new Thread(new Transfer(accounts.get(sourceID), accounts.get(destinationID), amount));
            thread.start();
        }

    }

    public Deque<String[]> getOrdersQueue() {
        return new LinkedList<>(orders);
    }

    public double getAccountBalance(int id) {
        if (id < 1)
            return Integer.MIN_VALUE;

        return accounts.get(id).getBalance();
    }

}
