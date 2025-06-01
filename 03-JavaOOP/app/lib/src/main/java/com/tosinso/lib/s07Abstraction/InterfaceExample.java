package com.tosinso.lib.s07Abstraction;

public class InterfaceExample {
    public static void main(String[] args) {
        Circle circle=new Circle(5);
        System.out.println("area of circle is:" +circle.calculateArea());
        System.out.println("perimeter of circle is:" +circle.calculatePerimeter());

        Rectangle rectangle=new Rectangle(4,6);
        System.out.println("area of rectangle is:" +rectangle.calculateArea());
        System.out.println("perimeter of rectangle is:" +rectangle.calculatePerimeter());

        Triangle triangle=new Triangle(3,6);
        System.out.println("area of triangle is:" +triangle.calculateArea());
        System.out.println("perimeter of triangle is:" +triangle.calculatePerimeter());
    }
}
interface Shape{
    double calculateArea();
    double calculatePerimeter();
}
class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea(){
        return Math.PI*radius*radius;
    }
    public double calculatePerimeter(){
        return 2*Math.PI*radius;
    }
}
class Rectangle implements Shape{
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double calculateArea(){
        return length*width;
    }
    public double calculatePerimeter(){
        return 2*(length+width);
    }
}
class Triangle implements Shape{
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    public double calculateArea(){
        return (base*height)/2;
    }

    @Override
    public double calculatePerimeter() {
        return base*3;
    }
}
class Square implements Shape{
    private double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return width*width;
    }

    @Override
    public double calculatePerimeter() {
        return 4*width;
    }
}
