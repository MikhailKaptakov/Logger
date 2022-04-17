package ru.kaptakov.java.logger;

import ru.kaptakov.java.storage.ListStorage;

import java.util.List;

public class ConsoleLogger extends Log.Logger<Boolean> {

    public ConsoleLogger() {
    }

    public ConsoleLogger(String title) {
        super(title);
    }

    @Override
    public void log(String message) {
        System.out.println(message);
    }

    @Override
    public Boolean getLog() {
        return isState();
    }
}
