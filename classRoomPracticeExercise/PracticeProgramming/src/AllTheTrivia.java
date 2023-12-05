import java.util.Scanner;

public class AllTheTrivia {
    public static void main(String[] args) {
        String inputOne, inputTwo, inputThree, inputFour;
        Scanner inputReader = new Scanner(System.in);
        //ask three trivia questions
        System.out.println("What unit is equivalent to 1,024 Gigabytes?");
        inputOne = inputReader.nextLine();
        System.out.println("Which planet is the only one that rotates clockwise in our Solar System?");
        inputTwo = inputReader.nextLine();
        System.out.println("What is the most abundant element in the earth's atmosphere?");
        inputThree = inputReader.nextLine();
        System.out.println("What is the most abundant element in the earth's atmosphere?");
        inputFour = inputReader.nextLine();

        //print a mix up sentense with the answers

        System.out.println("Wow, 1,024 Gigabytes is a " + inputThree + "!");
        System.out.println("I didn't know that the largest ever volcano was discovered on " + inputOne + "!");
        System.out.println("That's amazing that " + inputTwo + " is the most abundant element in the atmosphere...");
        System.out.println(inputFour + " is the only planet that rotates clockwise, neat!");

    }
}
