package ru.kaptakov.java.test;

import ru.kaptakov.java.logger.ListLogger;

public class Main {
    public static void main(String[] args) {
        ListLogger logger = new ListLogger();
        for (int i = 0; i< 10; i++) {
            logger.log(i + "");
        }
        System.out.println(logger.getLog().toString());
    }
}
