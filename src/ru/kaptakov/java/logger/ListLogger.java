package ru.kaptakov.java.logger;

import ru.kaptakov.java.storage.ListStorage;
import ru.kaptakov.java.storage.Recorder;

import java.util.ArrayList;
import java.util.List;

public class ListLogger extends Log.AbstractLogger<List<String>>{

    public ListLogger() {
        super(new ListStorage());
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
