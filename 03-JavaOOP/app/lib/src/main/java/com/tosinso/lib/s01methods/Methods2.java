package com.tosinso.lib.s01methods;

public class Methods2 {
    public static void main(String[] args) {
        sayHello("Mehdi", 3);
        sayHello("Ali");
        //method overloading
        sayHello("John",2l);
    }

    static void sayHello(String name, int n) {
        System.out.println("method with int input is running");
        for (int i = 0; i < n; i++)
            System.out.println("Hello " + name);
    }
    static void sayHello(String name) {
        int n=2;
        System.out.println("method without numeral input is running");
        for (int i = 0; i < n; i++)
            System.out.println("Hello " + name);
    }

    static void sayHello(String name, long n){
        System.out.println("method with long input is running");
        for (int i = 0; i < n; i++)
            System.out.println("Hello " + name);
    }
}
