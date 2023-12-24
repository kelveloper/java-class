package com.sg.foundations.flowcontrol.whiles;

import java.util.Random;

public class LazyTeenager {
    public static void main(String[] args) {


        boolean cleanRoom = false;
        int count = 1;
        // make a random generator from 1-100;
        Random randomizer = new Random();
        do {
            System.out.println("Clean your room!!" + " (x" + count + ")");
            int cleanUp = randomizer.nextInt(11 - 1) + 1;
            // System.out.println(cleanUp);
            if(cleanUp == 1 && count == 1) {
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            if (cleanUp == 1 || cleanUp == 2 && count == 2) {
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            if (cleanUp >= 3 && cleanUp <= 1 && count == 3) {
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            if (cleanUp >= 4 && cleanUp <= 1 && count == 4) {
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            if (cleanUp >= 5 && cleanUp <= 1 && count == 5) {
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            if (cleanUp >= 6 && cleanUp <= 1 && count == 6) {
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }
            if (count == 7) {
                System.out.println("Clean your room!! That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
                break;
            }
            count++;
        } while (!cleanRoom);
    }
}
