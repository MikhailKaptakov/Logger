package ru.kaptakov.java.test;

import ru.kaptakov.java.logger.ListLogger;
import ru.kaptakov.java.storage.FileStorage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        FileStorage fileStorage = FileStorage.createFileStorage(Paths.get("log"),
                "test", ".txt", 1, 2);
        ListLogger logger = new ListLogger("info");
        logger.setStorageCapacity(12);
        for (int i = 0; i< 500; i++) {
            logger.log(i + "");
            fileStorage.write(i + " ");
            if (i == 20) {
                logger.turnOff();
            }
        }
        System.out.println(logger.getLog().toString());
        System.out.println(logger.isState());
        logger.switchState();
        System.out.println(logger.isState());
    }
}
