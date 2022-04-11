package ru.kaptakov.java.logger;

public interface StorageWriter<M> {
    boolean write (M message);
}
