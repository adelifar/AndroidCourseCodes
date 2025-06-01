package com.tosinso.lib.s01TypeCating;

public class TypeCasting {
    //implicit (automatic)
    //explicit (manual)
    public static void main(String[] args){
        //implicit (automatic)
        int numInt=10;
        double numDouble=numInt;  //10.0
        System.out.println(numDouble);

        long numLong=numInt;

        short numShort=18;
        int numInt2=numShort;
        System.out.println(numInt2);

        //explicit (manual)  //data loss
        double pi=3.14;
        int intPi=(int) pi; //3
        System.out.println(intPi);


        int number=300;
        byte numByte=(byte) number;
        System.out.println(numByte);

        int myInt=70;
        char myChar=(char) myInt;
        System.out.println(myChar);

        int a=10;
        int b=5;
        int c=a+b;
        System.out.println(c);

        int n=10;
        char ch='A';
        int nn=(n+ch);
        System.out.println(nn);

        char ch2=(char) (n+ch);
        System.out.println(ch2);
    }
}
