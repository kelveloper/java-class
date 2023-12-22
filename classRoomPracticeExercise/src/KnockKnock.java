import java.util.Scanner;

public class KnockKnock {

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Knock Knock! Guess who!! ");
        String nameGuess = inputReader.nextLine();

        if (nameGuess.equals("Marty McFly")) { // if ".equals()" is changed to "==", it would not compare correctly.
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); // Sorry, had to!
        } else {
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
}