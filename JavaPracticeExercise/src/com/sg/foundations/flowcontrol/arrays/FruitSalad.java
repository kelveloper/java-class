package com.sg.foundations.flowcontrol.arrays;

import java.util.Arrays;

public class FruitSalad {

    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato",
                "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry",
                "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato",
                "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango",
                "Satsuma Orange", "Watermelon", "Snozzberry"};

        String[] fruitSalad = new String[12];
        int index = 0; // count index
        int countAll = 1, countApple = 1, countOrange = 1;
        // Code Recipe for fruit salad should go here!

        // As many berries as possible
        // No more than three kinds of apples
        // No more than two kinds of orange
        // Definitely no tomatoes
        // No more than twelve kinds of fruit

        for (int i = 0; i < fruit.length; i++) {
            String theFruit = fruit[i];
            if (index < 12 ) { // no more than 12
                if(theFruit.contains("berry")) {
                    fruitSalad[index] = theFruit;
                    index++;
                    // System.out.println(theFruit);
                } else if (theFruit.contains("Apple")) {
                    if (countApple < 4) { // can't put both if statement together cause else statement will override
                        fruitSalad[index] = theFruit;
                        countApple++;
                        index++;
                    }
                } else if (theFruit.contains("Orange")) {
                    if (countOrange < 3) {
                        fruitSalad[index] = theFruit;
                        countOrange++;
                        index++;
                    }
                } else if (theFruit.contains("Tomato")) continue;   // skip through tomato
                else {
                    fruitSalad[index] = theFruit;
                    index++;
                }
            }
            countAll++;

        }
         //System.out.println(Arrays.toString(fruitSalad));
        // Afterward, print out the total number and types of fruit in your fruit salad!
        System.out.print("There are " + index + " types of fruit: " );
        for (int i = 0; i < fruitSalad.length; i++) {
            System.out.print(fruitSalad[i] + ", ");
        }
    }
}