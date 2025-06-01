package com.tosinso.lib.s04Input;


import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        System.out.println("Hello !!");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name");
        String name=sc.nextLine();
//        System.out.println("You entered : "+name);
        System.out.println("Enter your age");
        int age=sc.nextInt();
//        System.out.println("Your age is: "+age);
        System.out.println("Enter your average");
        double avg=sc.nextDouble();

        System.out.println("You are "+name+" and you are "+age+" years old and your average is:"+avg);

    }
}
