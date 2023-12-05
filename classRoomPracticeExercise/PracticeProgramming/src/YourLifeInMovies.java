import java.util.Scanner;

public class YourLifeInMovies {
    public static void main(String[] args) {
        String name;
        int yearOfBirth;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Hey, let's play a game! What's your name? ");
        name = inputReader.nextLine();

        System.out.println("Ok, " + name + ", when were you born? ");
        String input = inputReader.nextLine();
        yearOfBirth = Integer.parseInt(input);
        System.out.println("Well " + name + "...");

        if( yearOfBirth < 2005 ) {
            System.out.println("Did you know that Pixar's 'Up' came out over a decade ago.");
        }
        if ( yearOfBirth < 1995) {
            System.out.println("Did you know that the first Harry Potter came out over 15 years ago.");
        }
        if ( yearOfBirth < 1985) {
            System.out.println("Did you know that Space Jam came out not last decade, but the one before THAT.");
        }
        if ( yearOfBirth < 1975) {
            System.out.println("Did you know that the original Jurassic Park release is closer to the first lunar landing than it is to today.");
        }
        if ( yearOfBirth < 1965) {
            System.out.println("Did you know that the MASH TV series has been around for almost half a century!");
        }
    }
}
