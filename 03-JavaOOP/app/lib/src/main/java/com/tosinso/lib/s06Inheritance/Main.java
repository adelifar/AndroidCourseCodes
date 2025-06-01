package com.tosinso.lib.s06Inheritance;

public class Main {
    public static void main(String[] args) {
        //inheritance
        Animal animal = new Animal("x1");
        animal.name = "x2";
        animal.eat();

        Cat cat = new Cat("jojo","white");
//        cat.name = "jojo";

        cat.eat();
//        cat.color = "white";
        cat.meow();
    }
}
//protected
class Animal {  //parent base super
    String name;
   protected int age;
//alt+insert

    public Animal(String name) {
        age=12;
        this.name = name;
    }

    void eat() {
        System.out.println(name + " is eating");
    }
}

class Cat extends Animal {  //child subclass

    public Cat(String name,String color) {
        super(name);
//        super("kitty");
        this.color=color;
        age=14;
    }

    String color;

    void meow() {
        System.out.println(name + " is meowing. color: " + color);
    }
}
