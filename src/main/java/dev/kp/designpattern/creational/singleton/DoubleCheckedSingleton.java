package dev.kp.designpattern.creational.singleton;

public class DoubleCheckedSingleton {
    private static volatile DoubleCheckedSingleton instance;
       /*
    This would be thread-safe, but every call to getInstance() would acquire a lock —
    even after the singleton is already created.
    That’s a performance hit for no reason after initialization.
    The double-checked locking pattern says:

    First check (unsynchronized):
    Quickly see if instance is already created — if it is, just return it immediately (fast path).

    Second check (inside synchronized block):
    If the instance was null during the first check, we synchronize and check again —
    because another thread might have created the instance just before we got the lock.
    If it’s still null, we create it.
    */

    private DoubleCheckedSingleton() {}

    public static DoubleCheckedSingleton getInstance() {
        // First check (not synchronized)
        if(instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                // Synchronize on the class object

                if(instance == null) {
                    // Second check (synchronized)
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
