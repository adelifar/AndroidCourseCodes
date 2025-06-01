package com.tosinso.lib.s01methods;

public class Methods {
    public static void main(String[] args) {
        sayHello("Mehdi", 5);
//        System.out.println("Hello Users");
        int a = 45;
        sayHello("Ali", 2);
//        System.out.println("Hello Users");

        int b = 78;
        b += a;
        sayHello("Milad", 3);
//        System.out.println("Hello Users");
        System.out.println(b);
        sayHello("John", 1);
//        System.out.println("Hello Users");
    }

//    static void sayHello(String name, int n) {
////        String nn="tosinso Users";
////        int n=3;
////        System.out.println("---------------------------------");
//        drawLine();
//        for (int i = 0; i < n; i++) {
//            System.out.println("Hello " + name);
//        }
//        drawLine();
////        System.out.println("---------------------------------");
//    }
    //void methodName(){}
static void sayHello(String  name, int n){
        drawLine();
        for (int i=0;i<n;i++)
            System.out.println("Hello " + name);
        drawLine();
}
    static void drawLine() {
        System.out.println("---------------------------------");
    }
}