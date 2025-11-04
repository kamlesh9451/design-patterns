package dev.kp.designpattern.creational.singleton;

public class BillPughSingleton {
    private BillPughSingleton() {
        // private constructor to prevent instantiation
    }

    // Static inner helper class
    private static class SingletonHelper {
        // The singleton instance is created when the SingletonHelper class is loaded
        /*When the getInstance() method is called for the first time, it triggers the loading of the SingletonHelper class.
          When the inner class is loaded, it creates the INSTANCE of BillPughSingleton.
          The final keyword ensures that the INSTANCE cannot be reassigned.*/
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // Global access point to get the singleton instance
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
