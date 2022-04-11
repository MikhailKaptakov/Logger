package ru.kaptakov.java.logger;

import java.util.List;

public class ListStorageConsoleNamedLogger<M> implements Log<M>,Log.LogReader<Boolean>{
    protected String title;
    protected ListStorageLogger<M> listStorageLogger;

    public ListStorageConsoleNamedLogger(ListStorage<M> storage, String title) {
        this.listStorageLogger = new ListStorageLogger<M>(storage);
        this.title = title;
    }

    @Override
    public boolean log(M message) {
        return listStorageLogger.log(message);
    }

    @Override
    public Boolean read() {
        List<M> messages = listStorageLogger.read();
        if (messages.isEmpty()) {
            return false;
        }
        for (M message : messages) {
            System.out.println(title + ": " + message);
        }
        return true;
    }
}
