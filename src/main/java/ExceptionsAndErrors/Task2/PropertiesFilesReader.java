package ExceptionsAndErrors.Task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class PropertiesFilesReader {
    private Properties properties = new Properties();

    public PropertiesFilesReader(String pathToFile) throws  PropertiesFileNotFoundException {
        readFile(pathToFile);
    }


    public void readFile(String filePath) throws PropertiesFileNotFoundException {
        File file = new File(filePath);
        if (!file.exists())
            throw new PropertiesFileNotFoundException();
        else {
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                if (properties.size() > 0)
                    properties = new Properties();
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public String getValue(String key) throws PropertiesKeyNotFoundException {
        if (properties.getProperty(key) == null)
            throw new PropertiesKeyNotFoundException();
        else
            return properties.getProperty(key);
    }

    public Set<String> getKeySet() {
        return new HashSet<String>(properties.stringPropertyNames());
    }
}
