package ru.kaptakov.java.logger;

public interface Log<M> {
    boolean log(final M message);

    interface LogReader<T> {
        T read();
    }

    class SimpleConsoleLogger implements Log<String> {
        @Override
        public boolean log(String message) {
            System.out.println(message);
            return true;
        }
    }

    class NamedConsoleLogger extends SimpleConsoleLogger {
        protected String title;

        public  NamedConsoleLogger(String title){
            this.title = title;
        }

        @Override
        public boolean log(String message) {
            return super.log(title + ": " + message);
        }
    }

    class SimpleObjectConsoleLogger implements Log<Object> {
        @Override
        public boolean log(Object message) {
            System.out.println(message.toString());
            return true;
        }
    }
}
