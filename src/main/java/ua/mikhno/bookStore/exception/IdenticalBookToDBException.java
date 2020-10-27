package ua.mikhno.bookStore.exception;

public class IdenticalBookToDBException extends Exception{
    public IdenticalBookToDBException(String message) {
        super(message);
    }
}
