package exceptions;

public class InventoryAlreadyExistsException extends RuntimeException{
    public InventoryAlreadyExistsException(String message) {
        super(message);
    }
}
