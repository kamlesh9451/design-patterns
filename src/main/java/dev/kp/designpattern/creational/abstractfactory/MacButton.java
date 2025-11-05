package dev.kp.designpattern.creational.abstractfactory;

public class MacButton implements Button{
    @Override
    public void click() {
        System.out.println("Mac Button Clicked");
    }

    @Override
    public void paint() {
        System.out.println("Painting Mac Button");
    }
}
