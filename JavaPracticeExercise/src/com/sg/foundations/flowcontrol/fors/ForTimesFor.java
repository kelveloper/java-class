package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;
public class ForTimesFor {
    public static void main(String[] args) {
        int sum, enterNum, enterAnswer;
        double count = 0;

        Scanner inputReader = new Scanner(System.in);

        // ask the user which times table
        System.out.println("Which times table shall I recite? ");
        enterNum = Integer.parseInt(inputReader.nextLine());

        // the user should answer each question going through 15
        for (int i = 1; i < 16; i++) {
            sum = enterNum * i;
            System.out.println(i + " * " + enterNum + " is: ");
            enterAnswer = Integer.parseInt(inputReader.nextLine());
            if (sum == enterAnswer ) {
                count++; // count each answers the user answer correct
                System.out.println("Correct!");
            } else {
                System.out.println("Sorry no, the answer is: " + sum);
            }
        }
        //System.out.println((count/4) * 100);

        // below 50% study more, over 90% send a congratulatory message
        if ((count/15) * 100 < 50) {
            System.out.println("You need to study more.");
        }
        else if ((count/15) * 100 > 90) {
            System.out.println("You're awesome! No need to study!");
        }
        System.out.println("You got " + count + " correct.");
    }
}