package dev.kp.designpattern.creational.factorymethod;

public class SlackNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Slack Notification sent with message: " + message);
    }
}
