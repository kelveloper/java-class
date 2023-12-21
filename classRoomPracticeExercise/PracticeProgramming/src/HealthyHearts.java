import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        int age, maxHeartRate;
        double lowZone, highZone;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("What  is your age? ");
        String input = inputReader.nextLine();
        age = Integer.parseInt(input);

        maxHeartRate = 220 - age;
        lowZone = maxHeartRate * 0.5;
        highZone = maxHeartRate * 0.85;

        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        System.out.println("Your target HR Zone is " + lowZone + " - " + highZone + " beats per minute.");

    }
}
