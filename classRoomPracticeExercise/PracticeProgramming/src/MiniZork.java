package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class MiniZork {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) {
                System.out.println("Turns out, sticking your hands on someone's mailbox isn't a good idea.");
                System.out.println("You've been eaten by a grue.");
            }
        } else if (action.equals("go to the house")) {
            System.out.println("As the door opens very gently, you can see a figure in the middle of the room.");
            System.out.println("It's too dark. You can't tell if it's an object or a living thing.");
            System.out.println("Start approaching the figure or turn back?");
            action = userInput.nextLine();

            if (action.equals("start approaching the figure")) {
                System.out.println("As you approach the figure, it becomes larger in size");
                System.out.println("You are scared now, so you tired to run away.");
                System.out.println("The figure grabs you tight and opens his mouth wide. You are swallowed.");
            }
        }  else if (action.equals("turn back")) { // can't get this work
            System.out.println("As you walk out the door, the figure in the back starts chasing towards you.");
            System.out.println("You closed the door just in time and hear screeching on the other side.");
            System.out.println("You survived the attacked.");
        }
    }
}