package org.tnsif.acc.c2tc.interfacedemo;

interface Vehicle {
    void start();

    void stop();

    int MAX_SPEED = 120;

    default void repair() {
        System.out.println("We provide repair service");
    }

    static void checkMaintenance() {
        System.out.println("Vehicle maintenance taken care here");
    }
}

class Car implements Vehicle {
    private String model;

    Car(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println("Car " + model + " starting");
    }

    @Override
    public void stop() {
        System.out.println("Car " + model + " stopping");
    }
}

class Bike implements Vehicle {
    private String type;

    Bike(String type) {
        this.type = type;
    }

    @Override
    public void start() {
        System.out.println("Bike " + type + " starting");
    }

    @Override
    public void stop() {
        System.out.println("Bike " + type + " stopping");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car("Sedan");
        car.start();
        car.repair();
        car.stop();

        Vehicle bike = new Bike("Sports");
        bike.start();
        bike.repair();
        bike.stop();

        System.out.println("Max speed allowed: " + Vehicle.MAX_SPEED);
        Vehicle.checkMaintenance();
    }
}
