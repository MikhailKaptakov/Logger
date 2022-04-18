package ru.kaptakov.java.log_exception;

public class IllegalFileStorageException extends RuntimeException{
    public IllegalFileStorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFileStorageException(String message) {
        super(message);
    }
}
