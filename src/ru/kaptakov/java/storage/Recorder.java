package ru.kaptakov.java.storage;

public interface Recorder<R> {
    R read();
    void write (String message);
}
