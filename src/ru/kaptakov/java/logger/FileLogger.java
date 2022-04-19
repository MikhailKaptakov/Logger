package ru.kaptakov.java.logger;

import ru.kaptakov.java.storage.Recorder;

import java.nio.file.Path;

public class FileLogger extends Log.CapacityLogger<Path[], String> implements CurrentDateTime{

    public FileLogger(Recorder.LogStorage<Path[], String> logStorage, String title) {
        super(logStorage, title);
    }

    @Override
    public void log(String message) {
        super.log(getStringCurrentTime() + " " + title.toUpperCase() + ": " + message);
    }

    @Override
    public String getLog() {
        return super.getLog();
    }
}
