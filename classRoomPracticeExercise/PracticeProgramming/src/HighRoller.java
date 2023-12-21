<<<<<<< HEAD
package com.sg.foundations.random;

import java.util.Random;
import java.util.Scanner;

public class HighRoller {

    public static void main(String[] args) {
        int userSide = 0;

        Random diceRoller = new Random();
        Scanner inputReader = new Scanner(System.in);

        System.out.println("How many sides does a single die has? ");
        userSide = Integer.parseInt(inputReader.nextLine());

        int rollResult = diceRoller.nextInt(userSide) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure! Ouch.");
        }
        if (rollResult == userSide) {
            System.out.println("You rolled a critical! Nice job!");
        }
    }
=======
package com.sg.foundations.random;

import java.util.Random;
import java.util.Scanner;

public class HighRoller {

    public static void main(String[] args) {
        int userSide = 0;

        Random diceRoller = new Random();
        Scanner inputReader = new Scanner(System.in);

        System.out.println("How many sides does a single die has? ");
        userSide = Integer.parseInt(inputReader.nextLine());

        int rollResult = diceRoller.nextInt(userSide) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure! Ouch.");
        }
        if (rollResult == userSide) {
            System.out.println("You rolled a critical! Nice job!");
        }
    }
>>>>>>> 6a51527984e9c113aa8e3981d95c1f1168074c88
}