package com.tosinso.lib.s08While;

public class WhileLoop {
    public static void main(String[] args) {
        //loop
        //while (condition){
        //statement
        // }
        int i=1;
        while (i<=5){
            System.out.println(i);
//            i=i+1;
            i++;
//            i--;
        }
//        while (true){
//            System.out.println(true);
//        }


        System.out.println("End of loop");

        int a=5,b=6;
//        a=a+b;
        a+=b;

        a=a-b;
        a-=b;

        a=a*b;
        a*=b;

    }
}
