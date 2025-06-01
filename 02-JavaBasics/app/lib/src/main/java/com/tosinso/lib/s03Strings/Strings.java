package com.tosinso.lib.s03Strings;

public class Strings {
    public static void main(String[] args){
        String sayHello="Hello tosinso users!";
        System.out.println(sayHello);

        String firstName="Mehdi";
        String lastName="Adeli far";
        System.out.println(firstName+" "+lastName);
        //concatenation
        int len=firstName.length();
        System.out.println("Length of firstName is: "+len);

        String hello=sayHello.substring(5,13);
        System.out.println(hello);

        System.out.println(hello.toUpperCase());
        System.out.println("Mehdi".toLowerCase());

    }
}
