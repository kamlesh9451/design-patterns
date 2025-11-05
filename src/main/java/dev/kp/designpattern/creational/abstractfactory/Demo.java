package dev.kp.designpattern.creational.abstractfactory;

public class Demo {
    public static void main(String[] args) {
        String os = System.getProperty("os.name");
        GUIFactory factory;

        if (os.contains("Windows")) {
            factory = new WindowsGUIFactory();
        } else {
            factory = new MacGUIFactory();
        }

        Application app = new Application(factory);
        app.render();
    }
    }
