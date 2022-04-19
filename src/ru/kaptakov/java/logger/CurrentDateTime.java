package ru.kaptakov.java.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface CurrentDateTime {
    default String getStringCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    default LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }
}
