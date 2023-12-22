import java.util.Scanner;
public class GuessMe {
    public static void main(String[] args) {
        // integer of my choice in a var
        int myNumber = 7;
        int yourNumber;
        // ask user to pick a number
        Scanner inputReader = new Scanner(System.in);
        // print what the user entered
        System.out.println("I've chosen a number. Betcha can't guess it! ");
        System.out.println("Your guess: ");
        String input = inputReader.nextLine();
        yourNumber = Integer.parseInt(input);
        System.out.println(yourNumber + "?");
        // if choice is equal to my number, print "Wow, nice guess! That was it!"
        if (yourNumber == myNumber) {
            System.out.println("Wow, nice guess! That was it!");
        }
        if (yourNumber < myNumber) {
            System.out.println("Ha, nice try - too low! I chose " + myNumber);
        }
        if (yourNumber > myNumber) {
            System.out.println("Too bad, way too high. I chose " + myNumber);
        }
        // if choice is less, print "Ha, nice try - too low! I chose #."
        // if choice is greater, print  "Too bad, way too high. I chose #."
    }
}