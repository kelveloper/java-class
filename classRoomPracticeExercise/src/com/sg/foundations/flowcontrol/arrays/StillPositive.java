package com.sg.foundations.flowcontrol.arrays;

import java.util.Arrays;

public class StillPositive {
    public static void main(String[] args) {
        int[] numbers = { 389, -447, 26, -485, 712, -884, 94, -64, 868, -776, 227, -744, 422, -109, 259, -500, 278, -219, 799, -311};
        // Arrays.sort(numbers); // sort the array
        System.out.println("Gotta stay positive ...!");
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number > 0) {
                System.out.print(number + " ");
            }
        }
    }
}
