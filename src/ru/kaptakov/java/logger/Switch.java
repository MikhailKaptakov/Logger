package ru.kaptakov.java.logger;

public interface Switch {
    void turnOn();
    void turnOff();
    void switchState();
    boolean isState();
}
