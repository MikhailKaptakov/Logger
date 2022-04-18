package ru.kaptakov.java.log_exception;

public class MessageNotWriteException extends RuntimeException{

    public MessageNotWriteException(Throwable cause) {
        super(cause);
    }

    public MessageNotWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
