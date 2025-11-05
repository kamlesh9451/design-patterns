package dev.kp.designpattern.creational.abstractfactory;

public class WindowsGUIFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowCheckBox();
    }
}
