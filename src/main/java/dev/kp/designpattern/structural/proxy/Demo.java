package dev.kp.designpattern.structural.proxy;

public class Demo {
    public static void main(String[] args) {
        Image image = new HighDefinitionImage("test_image.jpg");

        // Image will be loaded from disk
        image.display();
        System.out.println();

        //Lazy loading
        Image proxyImage = new ImageProxy("test_image1.jpg");
        proxyImage.display();
}
}
