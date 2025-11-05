package dev.kp.designpattern.creational.factorymethod;

public class NotificationFactory {
    public static Notification createNotification(String channel) {
        if (channel == null || channel.isEmpty()) {
            throw new IllegalArgumentException("Channel must not be null or empty");
        }
        return switch (channel.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            case "slack" -> new SlackNotification();
            default -> throw new IllegalArgumentException("Unknown channel: " + channel);
        };
    }
}
