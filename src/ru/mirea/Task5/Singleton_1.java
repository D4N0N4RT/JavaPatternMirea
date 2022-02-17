package ru.mirea.Task5;

public class Singleton_1 {
    private static Singleton_1 instance;
    public synchronized Singleton_1 getInstance() {
        if(instance == null) {
            instance = new Singleton_1();
            return instance;
        }
        return instance;
    }
}
