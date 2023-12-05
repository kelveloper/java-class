import java.util.Scanner;

public class WindowMaster {

    // with Methods!!!
    public static float readValue(Scanner sc, String prompt){
        // declare and initialize the Scanner


        //get input from user
        System.out.println(prompt);

        String valString = sc.nextLine();
        // convert String values of height and width to float values
        float value = Float.parseFloat(valString);

        return value;


    }


    public static void main(String[] args) {
        // declare variables for height and width
        float height;
        float width;

        // declare other variables
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;

        // declare and initialize the Scanner
        Scanner myScanner = new Scanner(System.in);

        // get input from the user

        height = readValue(myScanner,"Please enter window height");
        width = readValue(myScanner, "Please enter window width");



        // calculate the area of the window
        areaOfWindow = height * width;

        // calculate the perimeter of the window
        perimeterOfWindow = 2 * (height + width);

        // calculate the total cost - use a hard-coded value
        // for material cost
        cost = ((3.50f * areaOfWindow) + (2.25f * perimeterOfWindow));

        // display the results to the user
        System.out.println("Window height = " + height);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total Cost =  " + cost);
    }
}
