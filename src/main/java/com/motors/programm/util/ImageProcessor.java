package com.motors.programm.util;

public class ImageProcessor {
    private static ImageProcessor ourInstance = new ImageProcessor();

    public static ImageProcessor getInstance() {
        return ourInstance;
    }

    private ImageProcessor() {
    }

    public byte[] imageToByteArray() {
        return new byte[5];
    }
}
