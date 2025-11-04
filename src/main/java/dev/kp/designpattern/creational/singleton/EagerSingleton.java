package dev.kp.designpattern.creational.singleton;

public class EagerSingleton {
    private final static EagerSingleton instance = new EagerSingleton();

    /*In this method, we rely on the JVM to create the singleton instance when the class is loaded.
    The JVM guarantees that the instance will be created before any thread access the instance variable.
    This implementation is one of the simplest and inherently thread-safe without needing explicit synchronization.
    */
    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return instance;
    }
}
