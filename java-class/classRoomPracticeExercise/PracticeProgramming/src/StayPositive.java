import java.util.Scanner;

public class StayPositive {
    public static void main(String[] args) {
        int numberStart;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("Give me a positive number: ");
        numberStart = Integer.parseInt(inputReader.nextLine()); // convert String to int
        //System.out.println(numberStart);


        if ( numberStart > 0 ) {
            System.out.println("Counting down...");
            System.out.println();
            while (numberStart > 0) {
                System.out.print(numberStart + " ");
                numberStart--;
            }
            System.out.println();
            System.out.println("Blast off!");
        } else System.out.println("Number is not a positive integer.");
    }
}
