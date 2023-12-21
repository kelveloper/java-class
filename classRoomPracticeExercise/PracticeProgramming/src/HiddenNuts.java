<<<<<<< HEAD
package com.sg.foundations.basics.arrays;

import java.util.Random;

public class HiddenNuts {

    public static void main(String[] args) {

        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");

        // Nut finding code should go here!
        for (int i = 0; i < hidingSpots.length; i++) {
            if(hidingSpots[i] == ("Nut")) {
                System.out.println("Found it! It's in spot# " + i);
            }
        }
    }
}
=======
package com.sg.foundations.basics.arrays;

import java.util.Random;

public class HiddenNuts {

    public static void main(String[] args) {

        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");

        // Nut finding code should go here!
        for (int i = 0; i < hidingSpots.length; i++) {
            if(hidingSpots[i] == ("Nut")) {
                System.out.println("Found it! It's in spot# " + i);
            }
        }
    }
}
>>>>>>> 6a51527984e9c113aa8e3981d95c1f1168074c88
