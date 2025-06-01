package com.tosinso.lib.s07Abstraction;

public class Interface {
    public static void main(String[] args) {
        //interface
        VehicleInterface v1=new MyCar();
        v1.brake();
        v1=new Truck();
        v1.brake();


        Messenger messenger=new SMSMessenger();

        //...
        messenger=new EmailMessenger();

    }
}
interface VehicleInterface{
    void stop();
    void start();
    void brake();
}
class MyCar implements VehicleInterface{

    @Override
    public void stop() {
        System.out.println("The car stops");
    }

    @Override
    public void start() {
        System.out.println("The car starts");
    }

    @Override
    public void brake() {
        System.out.println("The car takes mechanical brake");
    }
}
class Truck implements VehicleInterface{

    @Override
    public void stop() {
        System.out.println("The Truck stops");
    }

    @Override
    public void start() {
        System.out.println("The Truck starts");
    }

    @Override
    public void brake() {
        System.out.println("The Truck takes Hydrolytic brake");
    }
}


interface Messenger{
    void sendMessage(String message,String to);
    void receiveMessage(String message,String from);
}
class SMSMessenger implements Messenger{

    @Override
    public void sendMessage(String message, String to) {
        System.out.println("Sending SMS to "+to +" the message is:"+message);
    }

    @Override
    public void receiveMessage(String message, String from) {
        System.out.println("Receiving SMS from "+from +" the message is:"+message);
    }
}
class EmailMessenger implements Messenger{

    @Override
    public void sendMessage(String message, String to) {
        System.out.println("Sending Email to "+to +" the message is:"+message);
    }

    @Override
    public void receiveMessage(String message, String from) {
        System.out.println("Receiving Email from "+from +" the message is:"+message);
    }
}