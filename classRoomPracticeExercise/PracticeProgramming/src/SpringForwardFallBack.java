<<<<<<< HEAD
package com.sg.foundations.flowcontrol.fors;

public class SpringForwardFallBack {

    public static void main(String[] args) {

        System.out.println("It's Spring...!");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + ", ");
        }

        System.out.println("\nOh no, it's fall...");
        for (int i = 10; i > 0; i--) {
            System.out.print(i + ", ");
        }
    }
}

/*
What are the start/stop ranges of output for both loops?
Spring loop starts from 0 and ends with 9 and fall loop starts from 10 and ends with 1.
How can you update the first loop so that it prints out the same range as the second loop,
changing only the start point or the stopping point?
both points
=======
package com.sg.foundations.flowcontrol.fors;

public class SpringForwardFallBack {

    public static void main(String[] args) {

        System.out.println("It's Spring...!");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + ", ");
        }

        System.out.println("\nOh no, it's fall...");
        for (int i = 10; i > 0; i--) {
            System.out.print(i + ", ");
        }
    }
}

/*
What are the start/stop ranges of output for both loops?
Spring loop starts from 0 and ends with 9 and fall loop starts from 10 and ends with 1.
How can you update the first loop so that it prints out the same range as the second loop,
changing only the start point or the stopping point?
both points
>>>>>>> 6a51527984e9c113aa8e3981d95c1f1168074c88
 */