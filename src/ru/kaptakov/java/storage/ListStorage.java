package ru.kaptakov.java.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStorage implements Recorder<List<String>>{
    private final List<String> storage;

    public ListStorage() {
        this.storage = new ArrayList<>();
    }

    public ListStorage(List<String> storage) {
        this.storage = storage;
    }

    @Override
    public List<String> read() {
        return Collections.unmodifiableList(storage);
    }

    @Override
    public void write(String message) {
        storage.add(message);
    }
}
