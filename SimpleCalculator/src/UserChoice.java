import java.util.Scanner;

public class UserChoice {

    private int operand1, operand2, operator;
    Scanner inputReader = new Scanner(System.in);

    public int getOperator() {
        return operator;
    }
    public void setOperator(int operator) {
        this.operator = operator;
    }

    public int getOperand1() {
        return operand1;
    }
    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }
    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public int inputOperator() {

        int userOperator;
        System.out.println("Choose the number that matches the math operation you want to use.");
        System.out.println("1. Addition         2. Subtraction");
        System.out.println("3. Multiplication   4. Division");
        System.out.println("5. Exit the Program");
        userOperator = Integer.parseInt(inputReader.nextLine());

        System.out.println(userOperator);
        return userOperator;
    }

    public void inputOperands() {
        int operand1, operand2;

        System.out.println("First integer: ");
        operand1 = Integer.parseInt(inputReader.nextLine());

        System.out.println("Second integer: ");
        operand2 = Integer.parseInt(inputReader.nextLine());
    }

    public void displayResult() {
        System.out.println(inputOperator());
    }

}
