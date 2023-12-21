import java.util.Scanner;

public class Adder2 {
    public static void main(String[] args) {
        // declare the number variables and initialize to 0
        int sum; // int sum = 0; variable "sum" initialize "0" is redundant warning, remove it.
        int operand1 = 0;
        int operand2 = 0;

        // declare and initialize a Scanner object - the Scanner reads
        // input from the console
        Scanner myScanner = new Scanner(System.in);

        // declare and initialize String (text) variables to hold the
        // values that the user types in - the Console only accepts
        // text, it knows nothing about numbers
        String stringOperand1;
        String stringOperand2;

        boolean isValid = false;

        do {

            try {
                System.out.println("Please enter the first number to be added (from 1 - 10): ");
                //System.out.println("Please enter the second number to be added: ");
                operand1 = Integer.parseInt(myScanner.nextLine());

                if (operand1 >= 1 && operand1 <= 10) {
                    System.out.println("Please enter the second number to be added (from 1 - 10): ");
                    operand2 = Integer.parseInt(myScanner.nextLine());

                        if (operand2 >= 1 && operand2 <= 10) {
                            isValid = true;
                        }
                }

            } catch(NumberFormatException ex) {
                System.out.println("That was not a number!");
            }

        } while(!isValid);

        // in order to add the values input by the user we must
        // convert the String values into int values.  We use the
        // parseInt method for this:
        //operand1 = Integer.parseInt(stringOperand1);
        //operand2 = Integer.parseInt(stringOperand2);

        // assign the sum of operand1 and operand2 to sum
        sum = operand1 + operand2;

        // print the sum to the console
        System.out.println("Sum is: " + sum);
    }
}
