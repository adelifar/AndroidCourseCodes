package com.tosinso.lib.s09ForLoop;

public class For {
    public static void main(String[] args) {
//        int j=1;
//        while (j<=10){
//            System.out.println(j);
//            j++;
//        }
//


       //for(initialization;condition;update) {}
        for (int i=1;i<=10;i++){
            if (i==6)
                break;
            System.out.println(i);
        }
        System.out.println("-------------------------------------------------");
        for (int i=1;i<=10;i++){
            if (i==3 || i==8)
                continue;
            System.out.println(i);
        }
    }

}
