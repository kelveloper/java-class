<<<<<<< HEAD
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
        System.out.println(myNumber);
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
=======
package com.sg.foundations.basics.core;

import java.util.Random;
import java.util.Scanner;

public class GuessMeFinally {
    public static void main(String[] args) {

        int myNumber, yourNumber;
        Random randomizer = new Random();
        Scanner inputReader = new Scanner(System.in);

        System.out.println("I've chosen a number between -100 and 100. Bet you can't guess it!");
        myNumber = randomizer.nextInt(100 + 100) - 100; // get negative #, subtract number at the end of the bound
        System.out.println(myNumber);
        // print what the user entered
        System.out.println("Your guess: ");
        yourNumber = Integer.parseInt(inputReader.nextLine());


        // If they get it on the first try print out "Wow, nice guess! That was it!"
        // otherwise print out "Finally! It's about time you got it!" *** STILL WRONG!!! ***
        if (yourNumber == myNumber) {
            System.out.println("Wow, nice guess! That was it!");
        }
        do {

            if (yourNumber == myNumber) {
                System.out.println("Finally! It's about time you got it!");
            }
            if (yourNumber != myNumber) {
                if (yourNumber < myNumber) {
                    System.out.println("Ha, nice try - too low! Try again!");
                    System.out.println("Your guess: ");
                    yourNumber = Integer.parseInt(inputReader.nextLine());

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

        } while (myNumber != yourNumber);
        // if choice is equal to my number, print "Wow, nice guess! That was it!"

    }
}
// We are here!!!
>>>>>>> 6a51527984e9c113aa8e3981d95c1f1168074c88
