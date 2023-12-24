package com.sg.foundations.flowcontrol.whiles;

public class LovesMe {
    public static void main(String[] args) {
        boolean isValid = false;
        int petals = 34;
        System.out.println("Well here goes nothing...");
        do {
            if (petals != 0) {
                System.out.println("It loves me NOT!");
                petals--;
            }
            if (petals != 0) {
                System.out.println("It LOVES me!");
                petals--;
            }
            if (petals == 0) {
                System.out.println("I knew it! It LOVES ME!");
                isValid = true;
            }

        } while(!isValid);

    }
}