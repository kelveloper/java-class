package com.sg.foundations.basics.core;

import java.util.Random;

public class CoinFlipper {
    public static void main(String[] args) {
        Random randomizer = new Random();

        boolean x = randomizer.nextBoolean();
        System.out.println("Ready, Set, Flip....!!");
        if (x == true) {
            System.out.println("You got TAILS!");
        } else System.out.println("You got HEADS!");
    }
}
