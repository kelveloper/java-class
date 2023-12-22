import java.util.Random;

public class BarelyControlledChaos {

    public static void main(String[] args) {


        String color = theColor(); // call color method here
        String animal = theAnimal(); // call animal method again here
        String colorAgain = theColorAgain(); // call color method again here
        int weight = theWeight(); // call number method,
        // with a range between 5 - 200
        int distance = theDistance(); // call number method,
        // with a range between 10 - 20
        int number = theNumber(); // call number method,
        // with a range between 10000 - 20000
        int time = theTime(); // call number method,
        // with a range between 2 - 6

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
                + weight + "lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");
    }

    public static String theColor() {

        return "blue";
    }
    public static String theAnimal() {

        return "pig";
    }
    public static String theColorAgain() {

        return "red";
    }
    public static int theWeight() {
        Random randomizer = new Random();
        return randomizer.nextInt((200 - 5) + 1) + 5;
    }
    public static int theDistance() {
        Random randomizer = new Random();
        return randomizer.nextInt((20 - 10) + 1) + 10;
    }
    public static int theTime() {
        Random randomizer = new Random();
        return randomizer.nextInt((20000 - 10000) + 1) + 10000;
    }
    public static int theNumber() {
        Random randomizer = new Random();
        return randomizer.nextInt((6 - 2) + 1) + 2;
    }
}