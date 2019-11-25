package ExceptionsAndErrors.Task2;

public class PropertiesKeyNotFoundException extends Exception{
    public PropertiesKeyNotFoundException() {
        super();
    }

    public PropertiesKeyNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Property key not found.";
    }
}
