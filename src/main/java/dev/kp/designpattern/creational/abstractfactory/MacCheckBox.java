package dev.kp.designpattern.creational.abstractfactory;

public class MacCheckBox implements CheckBox{
    @Override
    public void check() {
        System.out.println("Mac CheckBox checked");
    }

    @Override
    public void paint() {
        System.out.println("Painting Mac CheckBox");
    }
}
