package ExceptionsAndErrors.Task2;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try{
            PropertiesFilesReader propertiesFilesReader = new PropertiesFilesReader("src/main/resources/ExceptionsAndErrors/Task2/File.properties");
            Set<String> keySet = propertiesFilesReader.getKeySet();
            for (String key : keySet)
                System.out.println(propertiesFilesReader.getValue(key));
        } catch (PropertiesFileNotFoundException | PropertiesKeyNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
