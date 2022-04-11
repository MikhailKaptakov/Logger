package ru.kaptakov.java.logger;

import java.util.Collections;
import java.util.List;

public class ListStorage<M> implements StorageReader<List<M>>, StorageWriter<M> {
    private final List<M> storage;

    public ListStorage(List<M> storage) {
        this.storage = storage;
    }

    @Override
    public boolean write(M message) {
        storage.add(message);
        return true;
    }

    @Override
    public List<M> read() {
        return Collections.unmodifiableList(storage);
    }
}
