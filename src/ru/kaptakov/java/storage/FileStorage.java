package ru.kaptakov.java.storage;

import ru.kaptakov.java.log_exception.IllegalFileStorageException;
import ru.kaptakov.java.log_exception.MessageNotWriteException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.WRITE;

public class FileStorage extends Recorder.LogStorage<Path[], String> {
    private int currentFileIndex;

    public FileStorage(Path[] logFile, int fileSizeKb) {
        capacity = Math.max(fileSizeKb, 1);
        storage = logFile;

        for (Path current : logFile) {
            if (Files.exists(current)) {
                isFileCorrect(current);
            } else {
                try {
                    Files.createFile(current);
                } catch (IOException e) {
                    throw new IllegalFileStorageException("file" + current +" isn't create", e);
                }
            }
        }
        for (int i = 0; i < storage.length; i++) {
            currentFileIndex = i;
            if (!isOverCapacity()) {
                return;
            }
        }
        currentFileIndex = 0;
        System.out.println("set current file" + storage[currentFileIndex].toString());
    }

    public static FileStorage createFileStorage (Path logDirectory, String fileName, String fileExtension,
                                                 int fileSizeKb, int fileCount) {
        int countOfFiles = Math.max(fileCount, 1);
        if (!Files.isDirectory(logDirectory)) {
            throw new IllegalFileStorageException(logDirectory + " this path isn't lead to directory");
        }
        Path[] logFile;
        if (countOfFiles == 1) {
            logFile = new Path[1];
            logFile[0] = logDirectory.resolve(fileName + fileExtension);
        } else {
            logFile = new Path[countOfFiles];
            for (int i = 0; i<logFile.length; i++) {
                logFile[i] = logDirectory.resolve(fileName + (i+1) + fileExtension);
                if (Files.isDirectory(logFile[i])) {
                    throw new IllegalFileStorageException(logFile[i] + " final file path lead to directory");
                }
            }
        }
        return new FileStorage(logFile, fileSizeKb);
    }

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    @Override
    public void setCapacity(int capacity) {
        super.setCapacity(capacity);
    }

    @Override
    public String read() {
        return "log writes to " + storage[currentFileIndex].toString();
    }

    @Override
    public void write(String message) {
        if (isOverCapacity()) {
            if (currentFileIndex < storage.length - 1) {
                currentFileIndex++;
            } else {
                currentFileIndex = 0;
            }
            try {
                Files.writeString(storage[currentFileIndex], "");
            } catch (IOException e) {
                throw new MessageNotWriteException(e);
            }
        }
        try {
            Files.writeString(storage[currentFileIndex], message + System.lineSeparator(), WRITE, APPEND);
        } catch (IOException | UnsupportedOperationException | SecurityException  e){
            throw new MessageNotWriteException(e);
        }
    }

    private void isFileCorrect(Path filePath) throws IllegalFileStorageException{
        if (!Files.isRegularFile(filePath)) {
            throw new IllegalFileStorageException(filePath + " is not regularFile");
        }
        if (!Files.isWritable(filePath)) {
            throw new IllegalFileStorageException(filePath + " is not writableFile");
        }
    }

    private boolean isOverCapacity() {
        boolean check;
        try {
            check = Files.size(storage[currentFileIndex]) > (long) capacity * 1024;
        } catch (IOException e) {
            throw new IllegalFileStorageException("Can't read size of log file:" + storage[currentFileIndex].toString());
        }
        return check;
    }

}
