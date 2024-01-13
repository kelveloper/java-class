package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class BirthStones {
    public static void main(String[] args) {
        // 1. Ask the user for a number.
        int number;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("What month's birthstone do you want to know? ");
        String input = inputReader.nextLine();
        number = Integer.parseInt(input);
        // 2. Match that number against the month number.
        String monthNumber;
        switch (number) {
            case 1:
                monthNumber = "January's birthstone is Garnet.";
                break;
            case 2:
                monthNumber = "February's birthstone is Amethyst.";
                break;
            case 3:
                monthNumber = "March's birthstone is Aquamarine.";
                break;
            case 4:
                monthNumber = "April's birthstone is Diamond.";
                break;
            case 5:
                monthNumber = "May's birthstone is Emerald.";
                break;
            case 6:
                monthNumber = "June's birthstone is Pearl.";
                break;
            case 7:
                monthNumber = "Ruby's birthstone is Ruby.";
                break;
            case 8:
                monthNumber = "August's birthstone is Peridot.";
                break;
            case 9:
                monthNumber = "September's birthstone is Sapphire.";
                break;
            case 10:
                monthNumber = "October's birthstone is Opal.";
                break;
            case 11:
                monthNumber = "November's birthstone is Topaz.";
                break;
            case 12:
                monthNumber = "December's birthstone is Turquoise.";
                break;
            default:
                monthNumber = "I think you must be confused, it doesn't match a month.";
        }
        // 3. Print out the name of the month and its corresponding birthstone.
        System.out.println(monthNumber);
        // 4. If the user enters a value that doesn't correspond to a month number,
        //    the program should display an appropriate error message.

    }
}