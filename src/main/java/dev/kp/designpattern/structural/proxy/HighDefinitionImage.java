package dev.kp.designpattern.structural.proxy;

public class HighDefinitionImage implements Image{
    private String fileName;
    private byte[] imageData;
    HighDefinitionImage(String fileName){
        this.fileName = fileName;
        loadImageFromDisk(fileName);
    }

    private void loadImageFromDisk(String fileName) {
        System.out.println("Loading high definition image from disk: " + fileName);
        // Simulate loading image data
        try {
            Thread.sleep(1000);
            this.imageData = new byte[1024 * 1024]; // 1MB dummy data
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Image " + fileName + " loaded successfully.");

    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
