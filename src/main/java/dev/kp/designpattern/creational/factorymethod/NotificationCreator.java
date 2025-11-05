package dev.kp.designpattern.creational.factorymethod;

public abstract class NotificationCreator {

   abstract  Notification createNotification();

   void send(String message){
       Notification notification = createNotification();
       notification.send(message);
   }

}
