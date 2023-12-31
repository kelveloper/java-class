package com.sg.foundations.flowcontrol.whiles;

import java.util.Random;
import java.util.Scanner;

public class GuessMeFinally {
    public static void main(String[] args) {

        int myNumber, yourNumber;
        int count = 0;
        Random randomizer = new Random();
        Scanner inputReader = new Scanner(System.in);

        System.out.println("I've chosen a number between -100 and 100. Bet you can't guess it!");
        myNumber = randomizer.nextInt(100 + 100) - 100; // get negative #, subtract number at the end of the bound
        // System.out.println(myNumber); // THE RANDOM NUMBER
        // print what the user entered
        System.out.println("Your guess: ");
        yourNumber = Integer.parseInt(inputReader.nextLine());


        // If they get it on the first try print out "Wow, nice guess! That was it!"
        // otherwise print out "Finally! It's about time you got it!" *** STILL WRONG!!! ***

        do {
            if (yourNumber != myNumber) {
                if (yourNumber < myNumber) {
                    System.out.println("Ha, nice try - too low! Try again!");
                    System.out.println("Your guess: ");
                    yourNumber = Integer.parseInt(inputReader.nextLine());
                    count++;

                }
                if (yourNumber > myNumber) {
                    System.out.println("Too bad, way too high. Try again! ");
                    System.out.println("Your guess: ");
                    yourNumber = Integer.parseInt(inputReader.nextLine());
                    count++;
                }
            }

        } while (myNumber != yourNumber);
        // if choice is equal to my number, print "Wow, nice guess! That was it!"

        if (yourNumber == myNumber && count == 0) System.out.println("Wow, nice guess! That was it!");
        if (yourNumber == myNumber) {
            System.out.println("Finally! It's about time you got it!");
        }
    }
}