<<<<<<< HEAD
package com.sg.foundations.flowcontrol.whiles;

import java.util.Scanner;

public class RollerCoaster {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");

        String keepRiding = "y";
        int loopsLooped = 0;
        while (keepRiding.equals("y")) { // if we change only this to n, no loop would happen
            System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee.....!!!");
            System.out.print("Want to keep going? (y/n) : ");
            keepRiding = userInput.nextLine();
            loopsLooped++;
        }

        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped + " times!!");
    }
=======
package com.sg.foundations.flowcontrol.whiles;

import java.util.Scanner;

public class RollerCoaster {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");

        String keepRiding = "y";
        int loopsLooped = 0;
        while (keepRiding.equals("y")) { // if we change only this to n, no loop would happen
            System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee.....!!!");
            System.out.print("Want to keep going? (y/n) : ");
            keepRiding = userInput.nextLine();
            loopsLooped++;
        }

        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped + " times!!");
    }
>>>>>>> 6a51527984e9c113aa8e3981d95c1f1168074c88
}