package dev.kp.designpattern.creational.singleton;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        // private constructor to prevent instantiation
    }

    /*
    This would be thread-safe, but every call to getInstance() would acquire a lock —
    even after the singleton is already created.
    That’s a performance hit for no reason after initialization.
    */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
