package dev.kp.designpattern.creational.singleton;

public class Driver {
    public static void main(String[] args) {
        AppConfigManager singleton1 = AppConfigManager.INSTANCE;
        AppConfigManager singleton2 = AppConfigManager.INSTANCE;

        System.out.println("Are both instances the same? " + (singleton1 == singleton2));
        System.out.println(singleton1.getProperty("app.version"));
    }
}
