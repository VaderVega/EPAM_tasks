package GenericsAndCollections.Task2;

public class PropertiesFileNotFoundException extends Exception{
    public PropertiesFileNotFoundException() {
        super();
    }

    public PropertiesFileNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Properties file not found.";
    }
}
