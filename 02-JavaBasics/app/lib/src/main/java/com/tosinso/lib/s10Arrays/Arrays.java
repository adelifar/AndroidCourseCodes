package com.tosinso.lib.s10Arrays;

public class Arrays {
    public static void main(String[] args) {
//        int number=12;
//        int number2=15;
//        System.out.println(number);
//        System.out.println(number2);
//        number*=2;
//        number2*=2;
        //array: dataType[] name=new dataType[size];
        int[] numbers = new int[5];

        //index start from 0;
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;

        System.out.println(numbers[2]);
        System.out.println("Element at index 4:" + numbers[4]);

        numbers[3] = numbers[3] * 2;
        System.out.println("new value of element at index 3:" + numbers[3]);

        System.out.println("------------------------------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println(numbers[i]);
        }

        System.out.println("------------------------------------------------------");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element " + i + " is :" + numbers[i]);
        }

        System.out.println("------------------------------------------------------");
        //foreach  for collection
//        for (datatype name:collection){}
        for (int item : numbers) {
            System.out.println(item);
        }
        //datatype[][] name =new datatype[row][cols]
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        System.out.println("------------------------------------------------------");
        System.out.println(matrix[1][2]);

        int[] numbers2 = {4, 5, 6, 8};
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("------------------------------------------------------");
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
}
