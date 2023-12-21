import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int inputOperator;
        int operand1 = 0;
        int operand2 = 0;

        Scanner inputReader = new Scanner(System.in);
        SimpleCalculator calculator = new SimpleCalculator();

        System.out.println("1. Addition         2. Subtraction");
        System.out.println("3. Multiplication   4. Division");
        System.out.println("5. Exit the Program ");
        System.out.println("Choose the number that matches the math operation you want to use: ");
        inputOperator = Integer.parseInt(inputReader.nextLine());

            if (inputOperator == 5) {
                System.out.println("Thank you for using my calculator! Bye-bye!");
            }

            boolean isValid = false;
            do {
                try {
                    if(inputOperator > 0 && inputOperator < 5) {
                        System.out.println("Enter the first integer: ");
                        operand1 = Integer.parseInt(inputReader.nextLine());

                        System.out.println("Enter the second integer: ");
                        operand2 = Integer.parseInt(inputReader.nextLine());

                        isValid = true;
                    }

                } catch(NumberFormatException ex) { // make this error message pop up!
                    System.out.println("Not an integer. Try again. ");
                }
            } while (!isValid);
        switch (inputOperator) {
            case 1:
                System.out.println(calculator.add(operand1, operand2));
                break;
            case 2:
                System.out.println(calculator.subtract(operand1,operand2));
                break;
            case 3:
                System.out.println(calculator.multiple(operand1,operand2));
                break;
            case 4:
                System.out.println(calculator.divide(operand1,operand2));
                break;
        }
    }
}
