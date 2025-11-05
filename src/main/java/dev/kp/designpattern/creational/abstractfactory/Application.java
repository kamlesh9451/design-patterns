package dev.kp.designpattern.creational.abstractfactory;

public class Application {
    private final Button button;
    private final CheckBox checkBox;
    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkBox = factory.createCheckBox();
    }

    void render() {
        button.paint();
        checkBox.paint();
    }
}
