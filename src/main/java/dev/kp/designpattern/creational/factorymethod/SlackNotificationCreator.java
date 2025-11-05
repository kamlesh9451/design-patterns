package dev.kp.designpattern.creational.factorymethod;

public class SlackNotificationCreator extends NotificationCreator {
    @Override
    Notification createNotification() {
       return new SlackNotification();
    }
}
