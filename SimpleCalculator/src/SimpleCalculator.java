public class SimpleCalculator {

    public int add(int operand1, int operand2) {

        return operand1 + operand2;
    }

    public int subtract(int operand1, int operand2) {

        return operand1 - operand2;
    }

    public int multiple(int operand1, int operand2) {

        return operand1 * operand2;
    }

    public int divide(int operand1, int operand2) { // maybe use double instead of int
        if (operand2 == 0) {
            System.out.println("Can't divide any number with zero.");
            return -1; //error code
        }
        return operand1 / operand2;
    }

}
