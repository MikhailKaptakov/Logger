package ru.kaptakov.java.storage;

public interface Recorder<R> {
    R read();
    void write (String message);

    abstract class LogStorage<S,R> implements Recorder<R> {
        protected S storage;
        protected int capacity;

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }
    }
}

