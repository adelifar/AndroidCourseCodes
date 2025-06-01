package com.tosinso.lib.s03Constructor;

public class Constructor {
    public static void main(String[] args) {
        Car pride = new Car("pride", 900);
        pride.showWeight();
        Car samand = new Car("Samand", 1200);
        samand.showWeight();
        Car peykan = new Car("Paykan", 1000);
        peykan.showWeight();
    }
//    public static void main(String[] args) {
//        Car pride = new Car("pride",900);
////        pride.name = "pride";
////        pride.weight = 900;
//        pride.showWeight();
//
//        Car samand = new Car("Samand",1200);
////        samand.name = "Samand";
////        samand.weight = 1200;
//        samand.showWeight();
//        Car peykan = new Car("Paykan",1000);
////        peykan.name = "Paykan";
////        peykan.weight = 1000;
//        peykan.showWeight();
//    }
}

class Car {
    //fields
    int weight;
    int speed;
    int numberOfWheels;
    String name;

    //methods
    Car(String carName, int carWeight) {
        name = carName;
        weight = carWeight;
    }

    void start() {
        speed = 0;
        System.out.println("Starting car ");
    }

    void showWeight() {
        System.out.println("weight of " + name + " is: " + weight);
    }

    void honk() {
        numberOfWheels = 4;
        System.out.println("Beeeep!" + numberOfWheels);
    }
}
