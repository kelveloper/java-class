public class Adder {
    public static void main(String[] args) {
        // declare sum and initialize it to 0
        int sum = 0;
        // declare and initialize our operands
        int operand1 = 3;
        int operand2 = 2;

        //assign the sum of operand1 and operand2 to sum
        sum = operand1 + operand2;

        // NOTE: In the output below, the plus (+) operator
        // is acting as the string concatenation operator
        // instead of the addition operator.  In Java, we use
        // the plus (+) operator to concatentate (or glue together
        // string values.
        System.out.println("Sum is: " + sum);
    }
}
