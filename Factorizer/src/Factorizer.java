import java.util.Scanner;

public class Factorizer {
    public static void main(String[] args) {
        int userInput;
        int count = 0;
        int perfectNum = 0;
        int primeNum = 0;
        // This program must ask the user for the number the program will factor.
        Scanner inputReader = new Scanner(System.in);

        System.out.println("What number would you like to factor? ");
        userInput = Integer.parseInt(inputReader.nextLine());

        // The program must print out the original number.
        System.out.println("The factors of " + userInput + " are: ");

        // The program must print out each factor of the number (not including the number itself).
        for (int i = 1; i <= userInput; i++) {
            if (userInput % i == 0) {
                System.out.print(i + " ");
                count++;
                perfectNum += i;
            }
        }
        // The program must print out the total number of factors for the number.
        System.out.println();
        System.out.println(userInput + " has " + count + " factors.");

        // The program must print out whether or not the number is perfect.
        int truePerfectNum = perfectNum - userInput;

        if (truePerfectNum == userInput) {
            System.out.println(userInput + " is a perfect number");
        } else System.out.println(userInput + " is not a perfect number");

        // The program must print out whether or not the number is prime.
        if (count == 2) {
            System.out.println(userInput + " is a prime number");
        } else System.out.println(userInput + " is not a prime number");

    }
}
