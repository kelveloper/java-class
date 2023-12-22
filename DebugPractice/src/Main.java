import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Declare variables for height and width
        float height;
        float width;
        // Declare String variables to hold the user's height and width
        // input
        String stringHeight;
        String stringWidth;

        // Declare other variables
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;

        // Declare and initialize our Scanner
        Scanner sc = new Scanner(System.in);

        // Get input from user
        System.out.println("Please enter window height:");
        stringHeight = sc.nextLine();
        System.out.println("Please enter window width:");
        stringWidth = sc.nextLine();

        // Convert String values of height and width to floats
        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);

        // Calculate area of window
        areaOfWindow = height * width;

        // Calculate the perimeter of the window
        perimeterOfWindow = 2 * (height + width);

        // Calculate total cost - use hard coded for material cost
        cost = ((3.50f * areaOfWindow) + (2.25f * perimeterOfWindow));

        System.out.println("Window height = " + stringHeight);
        System.out.println("Window width = " + stringWidth);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total Cost = " + cost);
    }
}