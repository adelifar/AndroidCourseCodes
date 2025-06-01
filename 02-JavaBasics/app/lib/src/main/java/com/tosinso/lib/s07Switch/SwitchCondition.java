package com.tosinso.lib.s07Switch;

public class SwitchCondition {
    public static void main(String[] args) {
        //switch
        int dayOfWeek=3;
//        if (dayOfWeek==3)
//            System.out.println("Monday");
//        else if (dayOfWeek==4) {
//
//        }
        switch (dayOfWeek){
            case 1:
                System.out.println("Saturday");
                break;
            case 2:
                System.out.println("Sunday");
                break;
            case 3:
                System.out.println("Monday");
                break;
            case 4:
                System.out.println("Tuesday");
                break;
            case 5:
                System.out.println("Wednesday");
                break;
            case 6:
                System.out.println("Thursday");
                break;
            case 7:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Unknown day  of week");
        }

        //variable=condition?true:false

        boolean isWeekend=dayOfWeek>5 && dayOfWeek<=7?true:false;
         String weekend=dayOfWeek>5 && dayOfWeek<=7?"Enjow weekend!":"Back to work Please!";
        System.out.println(weekend);
    }
}
