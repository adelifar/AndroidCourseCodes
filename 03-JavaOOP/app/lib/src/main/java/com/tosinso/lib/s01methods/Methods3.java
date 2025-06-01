package com.tosinso.lib.s01methods;

public class Methods3 {
    public static void main(String[] args) {
        add(25,42);
        int c=add(14,41);
        System.out.println(c);

        int d=add(16,56);
        System.out.println(d);
        int result=add(c,d);
        System.out.println(result);
    }
    static int add(int a , int b){
        int c=a+b;
//        System.out.println(c);
        return c;
    }
}
