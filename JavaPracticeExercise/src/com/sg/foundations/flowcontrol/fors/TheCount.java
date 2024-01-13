package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;

public class TheCount {
    public static void main(String[] args) {
        int result = 0, count = 1, startValue, stopValue, incrementValue ;
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
        // prompt user a start, end, & increment value
        Scanner sc = new Scanner(System.in);
        System.out.print("Start at : ");
        startValue = sc.nextInt();
        System.out.print("Stop at : ");
        stopValue = sc.nextInt();
        System.out.print("Count by: ");
        incrementValue = sc.nextInt();

        for (int i = startValue; i <= stopValue; i++) {
            result = i;
            System.out.print(result + " ");
            i = (incrementValue - 1) + result;
            if (count % 3 == 0) {
                System.out.println(" - Ah ah ah!");
            }
            count++;
        }
    }
}
