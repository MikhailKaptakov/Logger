package ru.kaptakov.java.logger;

import java.util.List;

public class ListStorageLogger<M> implements Log<M>, Log.LogReader<List<M>> {
    protected ListStorage<M> storage;

    public ListStorageLogger(ListStorage<M> storage) {
        this.storage = storage;
    }

    @Override
    public boolean log(M message) {
        return storage.write(message);
    }

    @Override
    public List<M> read() {
        return storage.read();
    }
}
