package dev.kp.designpattern.creational.factorymethod;

public class FactoryMethodPatternDemo {
    public static void main(String[] args) {

        Notification smsNotification = NotificationFactory.createNotification("sms");
        smsNotification.send("Hello via SMS");

        Notification slackNotification = NotificationFactory.createNotification("slack");
        slackNotification.send("Hello via Slack");


        NotificationCreator notificationCreator ;
        notificationCreator= new EmailNotificationCreator();
        notificationCreator.send("Hello via Email");

        notificationCreator = new SlackNotificationCreator();
        notificationCreator.send("Hello via slack");


    }
}
