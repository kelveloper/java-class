package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;
public class TwoForsAndTenYearsAgo {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));
        }

        System.out.println("\nI can count backwards using a different way too...");

        for (int i = year; i >= year - 20; i--) {
            System.out.println( (year - i) + " years ago would be " + i);
        }
    }
}
/*
What are the ranges for the starting and stopping in each for loop? 11
Which one is clearer to you? Why? The first cause it normal and fewer operations
Change it so that the second loop counts back twenty years. DONE.
*/