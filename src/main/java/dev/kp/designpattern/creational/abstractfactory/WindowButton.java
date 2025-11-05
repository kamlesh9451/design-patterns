package dev.kp.designpattern.creational.abstractfactory;

public class WindowButton implements Button{
    @Override
    public void click() {
        System.out.println("Windows Button Clicked");
    }

    @Override
    public void paint() {
        System.out.println("Painting Windows Button");
    }
}
