package com.tosinso.lib.s02Operators;

public class Main {
    public static void main(String[] args) {
        //operand operator
        //arithmetic operators + - * / %
        //output same type
        System.out.println(1+2);
        System.out.println(1-2);


        System.out.println(2*2);
        System.out.println(10/5);
        System.out.println(13/5);
        System.out.println(13%5);


        //comparison operators  < > <= >= == !=
        //output boolean
        int x=10;
        System.out.println(x==9);
        System.out.println(x!=9);
        System.out.println(x==10);
        System.out.println(x>9);
        System.out.println(x<9);
        System.out.println(15<=12);
        System.out.println(12>=12);
        System.out.println(12>12);

        //logical operators  &&  || !
        //output boolean

        boolean isNight=false;
        boolean isLightOn=true;

        boolean canRest=isNight && isLightOn;
        System.out.println(canRest);

        boolean canWakeUp=!isNight;
        System.out.println(canWakeUp);

        boolean canWork=!isNight || isLightOn;
        System.out.println(canWork);




    }
}
