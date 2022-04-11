package ru.kaptakov.java.test;

import ru.kaptakov.java.logger.ListStorage;
import ru.kaptakov.java.logger.ListStorageConsoleNamedLogger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ListStorageConsoleNamedLogger<String> logger =
                new ListStorageConsoleNamedLogger<>(new ListStorage<>(new ArrayList<>()), "INFO");
        for (int i = 0; i<50; i++) {
            logger.log("message #" + i);
        }
        logger.read();
    }
}
