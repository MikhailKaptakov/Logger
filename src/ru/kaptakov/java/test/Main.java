package ru.kaptakov.java.test;

import ru.kaptakov.java.logger.FileLogger;
import ru.kaptakov.java.logger.ListLogger;
import ru.kaptakov.java.logger.Log;
import ru.kaptakov.java.storage.FileStorage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        FileStorage fileStorage = FileStorage.createFileStorage(Paths.get("log"),
                "test", ".txt", 5, 3);
        Log.Logger<String> logger2 = new FileLogger(fileStorage, "galia");
        ListLogger logger = new ListLogger("galia");
        logger.setStorageCapacity(12);
        for (int i = 0; i< 500; i++) {
            logger.log(i + "");
            logger2.log(i + "");
            if (i == 20) {
                logger.turnOff();
            }
            if (i == 450) {
                logger2.turnOff();
            }
            if (i==498) {
                logger2.turnOn();
            }
        }
        System.out.println(logger.getLog().toString());
        System.out.println(logger.isState());
        logger.switchState();
        System.out.println(logger.isState());
    }
}
