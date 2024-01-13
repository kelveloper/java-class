package com.sg.foundations.flowcontrol.whiles;

import java.util.Random;

public class MaybeItLovesMe {
    public static void main(String[] args) {
        boolean isValid = false;
        Random randomizer = new Random();
        int petals = randomizer.nextInt(13) + 76;
        int count = petals;

        System.out.println(petals);
        do {
            if (count != 0) {
                System.out.println("It loves me NOT!");
                count--;
            }
            if (count != 0) {
                System.out.println("It LOVES me!");
                count--;
            }
            if (count == 0) {
                if (petals % 2 == 0) {
                    System.out.println("Oh, wow! It really LOVES me!");
                }
                if (petals % 2 != 0) {
                    System.out.println("Awwww, bummer.");
                }
                isValid = true;
            }
        } while (!isValid);

    }
}