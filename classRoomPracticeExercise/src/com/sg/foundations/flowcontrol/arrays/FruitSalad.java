package com.sg.foundations.flowcontrol.arrays;

public class FruitSalad {

    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato",
                "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry",
                "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato",
                "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango",
                "Satsuma Orange", "Watermelon", "Snozzberry"};

        String[] fruitSalad = new String[12];
        int count = 0;
        // Code Recipe for fruit salad should go here!
        for (int i = 0; i < fruit.length; i++) {
            String theFruit = fruit[i];
            if (count == 13) {
                if (theFruit.contains("berry")) {
                    fruitSalad[i]
                } else if
            }
            count++;
        }
    }
}