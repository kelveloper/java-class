package com.sg.foundations.scanner;

import java.util.Scanner;

public class PassingTheTuringTest {
    public static void main(String[] args) {
        String name, color, favoriteFood;
        int favoriteNumber;
        Scanner inputReader = new Scanner(System.in);
        // Ask the user for their name.
        System.out.println("Hello there!");
        System.out.println("What's your name? ");
        name = inputReader.nextLine();

        // Display that name and tell them yours (or your AI's name!).
        System.out.println("Hi, " + name + "! I'm Kelvin.");

        // Ask them for their favorite color.
        System.out.println("What's your favorite color?");
        color = inputReader.nextLine();

        // Display the color they enter in a conversational way.
        System.out.println("Huh, " + color + "? Mine's royal purple.");

        // Do the same thing with favorite food and number, and then say goodbye!
        System.out.println("I really like blueberries. They're my favorite fruit, too.");
        System.out.println("What's YOUR favorite fruit, " + name + "?");
        favoriteFood = inputReader.nextLine();

        System.out.println("Really? " + favoriteFood + "? That's wild!");
        System.out.println("Speaking of favorites, what's your favorite number? ");
        String input = inputReader.nextLine();
        favoriteNumber = Integer.parseInt(input);

        System.out.println(favoriteNumber + " is a cool number. Mine's 7.");
        System.out.println("Did you know " + favoriteNumber + " * 7 is " + (favoriteNumber * 7)
            + "? That's a cool number too!");
        System.out.println("Well, thanks for talking to me, " + name + "!");



    }
}