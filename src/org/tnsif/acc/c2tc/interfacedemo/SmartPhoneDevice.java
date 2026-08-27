package org.tnsif.acc.c2tc.interfacedemo;

public class SmartPhoneDevice implements Camera, MusicPlayer {

    @Override
    public void takePhoto() {
        System.out.println("Taking a photo...");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing music...");
    }

    public static void main(String[] args) {
        SmartPhoneDevice phone = new SmartPhoneDevice();
        phone.takePhoto();
        phone.playMusic();
    }
}
