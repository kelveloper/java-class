package com.sg.foundations.basics.core;

import java.util.Random;
import java.util.Scanner;

public class GuessMeMore {
    public static void main(String[] args) {

        int myNumber, yourNumber;
        Random randomizer = new Random();
        Scanner inputReader = new Scanner(System.in);

        System.out.println("I've chosen a number between -100 and 100. Bet you can't guess it!");
        myNumber = randomizer.nextInt(100) - 100; // get negative #, subtract number at the end of the bound

        // print what the user entered
        System.out.println("Your guess: ");
        yourNumber = Integer.parseInt(inputReader.nextLine());

        // if choice is equal to my number, print "Wow, nice guess! That was it!"
        if (yourNumber == myNumber) {
            System.out.println("Wow, nice guess! That was it!");
        }
        if (yourNumber != myNumber) {
            if (yourNumber < myNumber) {
                System.out.println("Ha, nice try - too low! Try again!");
                System.out.println("Your guess: ");
                yourNumber = Integer.parseInt(inputReader.nextLine());

                if (yourNumber == myNumber) {
                    System.out.println("Wow, nice guess! That was it!");
                }

            }
            if (yourNumber > myNumber) {
                System.out.println("Too bad, way too high. Try again! ");
                System.out.println("Your guess: ");
                yourNumber = Integer.parseInt(inputReader.nextLine());

                if (yourNumber == myNumber) {
                    System.out.println("Wow, nice guess! That was it!");
                }

            }
        }
    }
}
