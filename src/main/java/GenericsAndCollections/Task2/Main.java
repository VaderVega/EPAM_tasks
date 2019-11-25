package GenericsAndCollections.Task2;


import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try{
            PropertiesFilesReader propertiesFilesReader = new PropertiesFilesReader("src/main/resources/ExceptionsAndErrors/Task2/File.properties");
            Map<String, String> propertiesContent = propertiesFilesReader.getPropertiesMap();
            System.out.println(propertiesContent);
        } catch (PropertiesFileNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
