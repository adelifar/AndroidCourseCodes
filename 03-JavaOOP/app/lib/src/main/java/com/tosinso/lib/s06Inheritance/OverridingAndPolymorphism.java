package com.tosinso.lib.s06Inheritance;

public class OverridingAndPolymorphism {
    public static void main(String[] args) {
        Car car=new Car("207");
        car.honk();
        car.start();
        car.stop();


        Vehicle v1=new Car("407");
        Vehicle v2=new Vehicle(18);
        Vehicle v3=new Truck(10);
        v1.start();
        v1.stop();

        v2.start();
        v2.stop();

        v3.start();
        v3.stop();
    }
}

class Vehicle {
    int numberOfWheels;

    public Vehicle(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    void start() {
        System.out.println("Vehicle starts");
    }

    void stop() {
        System.out.println("Vehicle stops");
    }
}

class Car extends Vehicle {
    String model;
    //constant
    private static final int numOfWheels = 4;

    public Car(String model) {
        super(numOfWheels);
        this.model = model;
    }
    void honk(){
        System.out.println("Beep!");
    }

    @Override
    void start() {
        System.out.println("The car starts");
    }

    @Override
    void stop() {
        System.out.println("The car stops");
    }
}
class Truck extends Vehicle{
    public Truck(int numberOfWheels) {
        super(numberOfWheels);
    }

    @Override
    void start() {
        System.out.println("Truck starts");
    }

    @Override
    void stop() {
        System.out.println("Truck stops");
    }
}
