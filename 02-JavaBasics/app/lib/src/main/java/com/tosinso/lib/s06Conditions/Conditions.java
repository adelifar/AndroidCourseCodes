package com.tosinso.lib.s06Conditions;

public class Conditions {
    public static void main(String[] args) {
        //if
        String movie="The revenant";
        int age=18;
        if (age<15){
            System.out.println("This movie is not suitable for your age!");
        }

        if (age<15){
            System.out.println("This movie is not suitable for your age!");
        }
        else{
            System.out.println("Enjoy watching "+movie);
        }


        age=35;
        if (age<7){
            System.out.println("watch coco melon");
        }
        else if (age<11){
            System.out.println("Kung fu panda");
        }
        else if (age<15){
            System.out.println("science documentary");
        }
        else{
            System.out.println("every movie -18");
        }
    }
}
