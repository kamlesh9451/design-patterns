package dev.kp.designpattern.creational.factorymethod;

public class EmailNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Sending Email Notification with message: " + message);
    }
}
