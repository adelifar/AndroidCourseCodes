package com.tosinso.lib.s07Abstraction;

public class AbstractVsInterface {
    public static void main(String[] args) {

    }
}
abstract class MyAbstract{
    private int myNumber;
    void doSomething(){
        System.out.println("Doing something");
    }
    abstract void myAbstractMethod();
}
interface MyInterface{
    void myMethod();
    int MyMethod2();
}

interface MyInterface2{
    void myMethod2();
    int MyMethod22();
}
class MyConcreteClass extends MyAbstract implements MyInterface,MyInterface2{

    @Override
    void myAbstractMethod() {

    }

    @Override
    public void myMethod() {

    }

    @Override
    public int MyMethod2() {
        return 0;
    }

    @Override
    public void myMethod2() {

    }

    @Override
    public int MyMethod22() {
        return 0;
    }
}
