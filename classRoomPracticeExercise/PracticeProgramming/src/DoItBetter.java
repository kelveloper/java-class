<<<<<<< HEAD
import java.util.Scanner;

public class DoItBetter {
    public static void main(String[] args) {
        int numberOfHotDogs, numberOfLanguages;
        double miles;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Yo bro, how many miles can you run? ");
        String input1 = inputReader.nextLine();
        miles = Double.parseDouble(input1);

        System.out.println("And how many hot dogs can you eat? ");
        String input2 = inputReader.nextLine();
        numberOfHotDogs = Integer.parseInt(input2);

        System.out.println("Last question. How many languages do you speak? ");
        String input3 = inputReader.nextLine();
        numberOfLanguages = Integer.parseInt(input3);

        System.out.println("HAHA! I can run " + (miles * 2.0) + " miles.");
        System.out.println("I can also eat " + (numberOfHotDogs * 2) + " hot dogs.");
        System.out.println("And in case you were wondering, I know " + (numberOfLanguages * 2) + " languages. Twice as much as you!");

    }
}
=======
import java.util.Scanner;

public class DoItBetter {
    public static void main(String[] args) {
        int numberOfHotDogs, numberOfLanguages;
        double miles;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Yo bro, how many miles can you run? ");
        String input1 = inputReader.nextLine();
        miles = Double.parseDouble(input1);

        System.out.println("And how many hot dogs can you eat? ");
        String input2 = inputReader.nextLine();
        numberOfHotDogs = Integer.parseInt(input2);

        System.out.println("Last question. How many languages do you speak? ");
        String input3 = inputReader.nextLine();
        numberOfLanguages = Integer.parseInt(input3);

        System.out.println("HAHA! I can run " + (miles * 2.0) + " miles.");
        System.out.println("I can also eat " + (numberOfHotDogs * 2) + " hot dogs.");
        System.out.println("And in case you were wondering, I know " + (numberOfLanguages * 2) + " languages. Twice as much as you!");

    }
}
>>>>>>> 6a51527984e9c113aa8e3981d95c1f1168074c88
