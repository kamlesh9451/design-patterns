package dev.kp.designpattern.creational.factorymethod;

public class SMSNotificationCreator extends NotificationCreator {
    @Override
    Notification createNotification() {
       return new SMSNotification();
    }
}
