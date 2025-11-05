package dev.kp.designpattern.structural.proxy;

import java.util.Objects;

public class ImageProxy implements Image {

    String fileName;
    HighDefinitionImage image;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
        System.out.println("ImageProxy: Created for " + fileName + ". Real image not loaded yet.");
    }

    @Override
    public void display() {
        if (Objects.isNull(image)) {
            System.out.println("ImageProxy: display() requested for " + fileName + ". Loading high-resolution image...");
            image = new HighDefinitionImage(fileName);
        } else {
            System.out.println("ImageProxy: Using cached high-resolution image for " + fileName);
        }
        image.display();
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
