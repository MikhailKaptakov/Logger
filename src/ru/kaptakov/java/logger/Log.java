package ru.kaptakov.java.logger;

import ru.kaptakov.java.storage.Recorder;

public interface Log<R> {
    void log(String message);
    R getLog();

   // impl Switch
   abstract class Logger<R> implements Log<R>, Switch {
        protected boolean state;
        protected String title;

       public Logger() {
           this.state = true;
           this.title = "";
       }

       public Logger(String title) {
           this.title = title;
       }

       public String getTitle() {
           return title;
       }

       @Override
        public void turnOn() {
            this.state = true;
        }

        @Override
        public void turnOff() {
            this.state = false;
        }

        @Override
        public void switchState() {
            this.state = !this.state;
        }

        @Override
        public boolean isState() {
            return this.state;
        }
    }

   abstract class CapacityLogger<S,R> extends Logger<R>{
        protected Recorder.LogStorage<S,R> logStorage;

       public CapacityLogger(Recorder.LogStorage<S,R> logStorage) {
           this.logStorage = logStorage;
       }

       public CapacityLogger(Recorder.LogStorage<S,R> logStorage, String title) {
           this.title = title;
           this.logStorage = logStorage;
       }

       @Override
       public void log(String message) {
           if (!this.state) {
               return;
           }
           logStorage.write(message);
       }

       @Override
       public R getLog() {
           return logStorage.read();
       }
   }
}
