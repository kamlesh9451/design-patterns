package dev.kp.designpattern.creational.factorymethod;

public class SMSNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Sending SMS notification with message: " + message);
    }
}
