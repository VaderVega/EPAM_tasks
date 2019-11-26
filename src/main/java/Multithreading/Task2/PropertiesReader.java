package Multithreading.Task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {
    private File file;
    private final Properties properties = new Properties();
    private boolean isFileReading = false;

    public PropertiesReader(File file) {
        checkIsFileExistAndNotNull(file);
        this.file = file;
    }

    public void readFile(File file) {
        checkIsFileExistAndNotNull(file);
        synchronized (properties) {
            this.file = file;
            isFileReading = false;
        }
    }

    public String getValue(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key value cannot be null.");
        }

        synchronized (properties) {
            isFirstRead();
            return properties.getProperty(key);
        }
    }

    public Set<String> getAllKeys() {
        synchronized (properties) {
            isFirstRead();
            return new HashSet<String>(properties.stringPropertyNames());
        }
    }

    private void checkIsFileExistAndNotNull(File file) {
        if (file == null)
            throw new IllegalArgumentException("File cannot be null.");

        if (!file.exists())
            throw new IllegalArgumentException("The specified file doesn't exist.");
    }

    private void isFirstRead() {
        if (!isFileReading) {
            try(BufferedReader in = new BufferedReader(new FileReader(file))) {
                properties.load(in);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

}
