<<<<<<< HEAD
import java.util.Scanner;

public class ForTimes {
    public static void main(String[] args) {
        int enterNum, sum;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Which times table shall I recite? ");
        enterNum = Integer.parseInt(inputReader.nextLine());

        // loop through the enterNum 15 times
        for ( int i = 1; i < 16; i++ ) {
            sum = i * enterNum;
            System.out.println(i + " * " + enterNum + " is: " + sum); // print out the times table
        }

    }
}
=======
import java.util.Scanner;

public class ForTimes {
    public static void main(String[] args) {
        int enterNum, sum;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Which times table shall I recite? ");
        enterNum = Integer.parseInt(inputReader.nextLine());

        // loop through the enterNum 15 times
        for ( int i = 1; i < 16; i++ ) {
            sum = i * enterNum;
            System.out.println(i + " * " + enterNum + " is: " + sum); // print out the times table
        }

    }
}
>>>>>>> 6a51527984e9c113aa8e3981d95c1f1168074c88
