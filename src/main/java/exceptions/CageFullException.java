package main.java.exceptions;

public class CageFullException extends RuntimeException {
    public CageFullException(String message) {
        super(message);
    }
}
