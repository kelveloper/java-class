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

            for (int i = numberStart; i >= 0; i--) {
                if (((i + 1) % 10) == 0 && i != 0) {
                    System.out.println();
                }
                System.out.print(i + " ");

            }
            System.out.println();
            System.out.println("Blast off!");
        } else System.out.println("Number is not a positive integer.");
    }
}