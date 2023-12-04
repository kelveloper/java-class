public class SimpleCalculator {
    private int add, subtract, divide, multiple;

    public int getAdd(int operand1, int operand2) {
        return operand1 + operand2;
    }

    public int getSubtract(int operand1, int operand2) {
        return operand1 - operand2;
    }

    public int getMultiple(int operand1, int operand2) {
        return operand1 * operand2;
    }

    public int getDivide(int operand1, int operand2) {
        return operand1 / operand2;
    }
}
