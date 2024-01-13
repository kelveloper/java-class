package com.sg.foundations.flowcontrol.whiles;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class BewareTheKraken {
    public static void main(String[] args) {

        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

        int depthDivedInFt = 0;
        Scanner input = new Scanner(System.in);
        Random randomizer = new Random();
        String[] arr = new String[3];
        arr[0] = "shark";
        arr[1] = "catfish";
        arr[2] = "eel";

        // System.out.println(arr[0]);
        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        while(depthDivedInFt < 36200){
            System.out.println("Do you want to stop? y/n: ");
            String result = input.nextLine();

            //pick a random fish
            int randomFish = randomizer.nextInt(3);
            //System.out.println(randomFish);
            if(result.equals("y")) {
                break;
            }
            System.out.println("So far, we've swum " + depthDivedInFt + " feet");
            System.out.println("Oh look! It's a " + arr[randomFish] + "!");

            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }

            // I can swim, really fast! 500ft at a time!
            depthDivedInFt += 1000;
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}
//start here!!