package com.tosinso.lib.s07Abstraction;

public class Abstraction {
    public static void main(String[] args) {
        Vehicle vehicle=new Car(4);
        vehicle.start();
    }
}

abstract class Vehicle {
    int numberOfWheels;

    public Vehicle(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    abstract void start() ;

  abstract   void stop() ;
}
class Car extends Vehicle{

    public Car(int numberOfWheels) {
        super(numberOfWheels);
    }

    @Override
    void start() {
        System.out.println("The car is starting..");
    }

    @Override
    void stop() {
        System.out.println("The car is stopping...");
    }
}
