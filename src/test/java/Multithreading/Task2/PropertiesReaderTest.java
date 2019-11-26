package Multithreading.Task2;

import org.junit.Test;

import java.io.File;
import java.util.Set;

import static org.junit.Assert.*;

public class PropertiesReaderTest {
    File file = new File("src/test/resources/Multithreading/Task2/file.properties");
    PropertiesReader propertiesReader = new PropertiesReader(file);

    @Test
    public void checkValidValueIfKeyExists() throws Exception {
        String value = propertiesReader.getValue("k1");
        assertEquals("v1", value);
    }

    @Test
    public void checkReturnAllKeys() throws Exception {
        Set<String> set = propertiesReader.getAllKeys();
        assertTrue(set.contains("k1"));
        assertTrue(set.contains("k2"));
        assertTrue(set.contains("k3"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionIfFileIsNotExist() throws Exception {
        PropertiesReader temp = new PropertiesReader(new File(""));
    }

    @Test
    public void throwExceptionIfPropertiesKeyNotFound() throws Exception {
        assertNull(propertiesReader.getValue(""));
    }
}
