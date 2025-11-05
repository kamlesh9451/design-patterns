package dev.kp.designpattern.creational.abstractfactory;

public class WindowCheckBox implements CheckBox {

    @Override
    public void check() {
        System.out.println("Window CheckBox checked.");
    }

    @Override
    public void paint() {
        System.out.println("Painting a Windows style CheckBox.");
    }
}
