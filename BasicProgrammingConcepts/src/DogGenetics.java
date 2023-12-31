import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args) {
        /*
Ever heard of those places that you can mail in some of your dog’s hair, and they’ll send back a genetic analysis report to tell you what kind of dogs are in your most beloved pet’s ancestry?

Well, we don’t know how to do that. But we DO know how to generate random numbers. And half the time, that’s good enough. Especially for the Internet.

What You Should Do
Program Name: DogGenetics
Write a program that asks the user for the name of their dog, and then generates a fake DNA background report on the pet dog.
It should assign a random percentage using five dog breeds. The total percentage should be 100%.
         */
        int beagle = 0, poodle = 0, frenchBulldog = 0, dachshund = 0, yorkie = 0;
        String dogName;

        Scanner sc = new Scanner(System.in);
        Random randomizer = new Random();

        int countPercentage = 0; // count till 100

        //ask user name of dog
        System.out.print("What is your dog's name? ");
        dogName = sc.nextLine();

        while (countPercentage != 100) {
            // make if and else till it's 100 with 5 breeds
            beagle = randomizer.nextInt(101);
            poodle = randomizer.nextInt(101);
            frenchBulldog = randomizer.nextInt(101);
            dachshund = randomizer.nextInt(101);
            yorkie = randomizer.nextInt(101);

            countPercentage = beagle + poodle + frenchBulldog + dachshund + yorkie;
        }
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.");
        System.out.println();

        System.out.println(dogName + " is:");
        System.out.println();

        System.out.println("Beagle: " + beagle + "%");
        System.out.println("Poodle: " + poodle + "%");
        System.out.println("French Bulldog: " + frenchBulldog + "%");
        System.out.println("Daschund: " + dachshund + "%");
        System.out.println("Yorkie: " + yorkie + "%");

        System.out.println();
        System.out.println("Wow, that's QUITE the dog!");
        // Using five dog breeds have a random percentage from 0-100

    }
}
