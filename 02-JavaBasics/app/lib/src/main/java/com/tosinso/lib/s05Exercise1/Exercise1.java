package com.tosinso.lib.s05Exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        int a=0, b=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first number");
        a=sc.nextInt();
        System.out.println("Enter second number");
        b=sc.nextInt();

        int div=a/b;
        System.out.println("The result of division is: "+div);

        int reminder=a%b;
        System.out.println("The result of reminder is: "+reminder);
    }
}
