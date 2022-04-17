package ru.kaptakov.java.test;

import ru.kaptakov.java.logger.ListLogger;

public class Main {
    public static void main(String[] args) {
        ListLogger logger = new ListLogger("info");
        logger.setStorageCapacity(12);
        for (int i = 0; i< 30; i++) {
            logger.log(i + "");
            if (i == 20) {
                logger.turnOff();
            }
            if (i == 25) {
                logger.turnOn();
            }
        }
        System.out.println(logger.getLog().toString());
        System.out.println(logger.isState());
        logger.switchState();
        System.out.println(logger.isState());
    }
}
