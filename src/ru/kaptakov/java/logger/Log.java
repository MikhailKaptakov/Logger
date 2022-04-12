package ru.kaptakov.java.logger;

import ru.kaptakov.java.storage.Recorder;

public interface Log<R> {
    void log(String message);
    R getLog();

   abstract class AbstractLogger<R> implements Log<R> {
        protected Recorder<R> recorder;

       public AbstractLogger(Recorder<R> recorder) {
           this.recorder = recorder;
       }

       @Override
       public void log(String message) {
           recorder.write(message);
       }

       @Override
       public R getLog() {
           return recorder.read();
       }
   }
}
