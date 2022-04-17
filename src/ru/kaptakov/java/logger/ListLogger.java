package ru.kaptakov.java.logger;

import ru.kaptakov.java.storage.ListStorage;
import ru.kaptakov.java.storage.Recorder;

import java.util.List;

public class ListLogger extends Log.CapacityLogger<List<String>, List<String>> {

    public ListLogger() {
        super(new ListStorage());
    }

    public ListLogger(String title) {
        super(new ListStorage(), title);
    }

    public void setStorageCapacity(int capacity) {
        logStorage.setCapacity(capacity);
    }

    @Override
    public void log(String message) {
        super.log(message);
    }

    @Override
    public List<String> getLog() {
        return super.getLog();
    }
}
