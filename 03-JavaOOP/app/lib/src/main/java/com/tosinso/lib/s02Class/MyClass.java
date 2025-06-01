package com.tosinso.lib.s02Class;

public class MyClass {
    public static void main(String[] args) {
//class
        //car Car
        //class

        Car pride = new Car();  //object
        pride.name = "pride";
        pride.weight = 900;
        pride.showWeight();

        Car samand = new Car();
        samand.name = "Samand";
        samand.weight = 1200;
        samand.showWeight();
        Car peykan = new Car();
        peykan.name = "Paykan";
        peykan.weight = 1000;
        peykan.showWeight();
    }


}

class Car {
    //fields
    int weight;
    int speed;
    int numberOfWheels;
    String name;

    //methods
    void start() {
        speed = 0;
        System.out.println("Starting car ");
    }

    void showWeight() {
        System.out.println("weight of " + name + " is: " + weight);
    }

    void horn() {
        numberOfWheels = 4;
        System.out.println("Beeeep!" + numberOfWheels);
    }
}
