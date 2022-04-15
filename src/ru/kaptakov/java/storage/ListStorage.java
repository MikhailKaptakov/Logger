package ru.kaptakov.java.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStorage extends Recorder.LogStorage<List<String>, List<String>>{
    private int currentIndex = 0;

    public ListStorage() {
        this.storage = new ArrayList<>();
        this.capacity = 10;
    }

    public ListStorage(int capacity) {
        this.storage = new ArrayList<>();
        this.capacity = capacity;
    }

    public ListStorage(List<String> storage, int capacity) {
        this.storage = storage;
        this.capacity = capacity;
    }

    @Override
    public List<String> read() {
        return Collections.unmodifiableList(storage);
    }

    @Override
    public void write(String message) {
        if(currentIndex >= capacity) {
            currentIndex = 0;
        }
        if (currentIndex < storage.size()) {
            storage.set(currentIndex, message);
        } else {
            storage.add(message);
        }
        currentIndex++;
    }

}
