package dev.kp.designpattern.creational.factorymethod;

public class EmailNotificationCreator extends NotificationCreator {

    @Override
    Notification createNotification() {
        return new EmailNotification();
    }
}
