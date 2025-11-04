package dev.kp.designpattern.creational.builder;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class BuilderDemo {

    final List<String> names = new ArrayList<>();


    public static void main(String[] args) {
        User user1 = new User.Builder("john_doe", "password123")
                .age(30)
                .email("test")
                .address("test")
                .isSubscribed(true)
                .build();
        System.out.println("Employee Created: " + user1);

        User user2 = new User.Builder("john_doe", "password123")
                .age(30)
                .email("test")
                .address("test")
                .isSubscribed(true)
                .build();
        System.out.println("Employee Created: " + user2);

        System.out.println(user1.equals(user2));
        System.out.println(user1 == user2);

        List<User> userList = new ArrayList<>();
        userList.add(user1);

        System.out.println(userList.contains(user2));

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        Thread writer = new Thread(() -> {
            list.add("A");
            list.add("B");
        });

        Thread reader = new Thread(() -> {
            for (String s : list) {
                System.out.println(s);
            }
        });

        writer.start();
        reader.start();

    }





}

