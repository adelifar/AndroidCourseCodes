package com.tosinso.lib.s05Encapsulation;

public class Main {
    //encapsulation
    public static void main(String[] args){
        Car myCar = new Car();
//        myCar.name = "BMW";
        myCar.setName("BMW");
        myCar.setYear( 1998);

        System.out.println(myCar.getName());


        Student mehdi=new Student();
//        mehdi.average=89;
        mehdi.setAverage(16.5);
        System.out.println(mehdi.getAverage());
        mehdi.setAverage(89);
        System.out.println(mehdi.getAverage());

    }
}

class Car {
    private int year;
    private String name;
    //getter , setter
    public int getYear(){
        return year;
    }
    public String getName(){

        return name;
    }
    public void setYear(int value){
        year=value;
    }
    public void setName(String value){
        name=value;
    }

    void honk() {
        System.out.println("Beeep");
    }
}

class Student{
   private double average;
    public double getAverage(){
        return average;
    }
    public void setAverage(double value){
        if (value>20 || value<0)
            return;
        average=value;
    }

}
