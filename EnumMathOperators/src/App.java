public class App {
    public static void main(String[] args) {
        int addition =  calculate(MathOperator.PLUS, 3,4);
        int subtraction = calculate(MathOperator.MINUS,3,4);
        int multiplication =  calculate(MathOperator.MULTIPLY, 3,4);
        int division =  calculate(MathOperator.DIVIDE, 3,4);
        System.out.println("For operand1, 3, and operand2, 4 here is the addition result: " + addition);
        System.out.println("For operand1, 3, and operand2, 4 here is the subtraction result: " + subtraction);
        System.out.println("For operand1, 3, and operand2, 4 here is the multiplication result: " + multiplication);
        System.out.println("For operand1, 3, and operand2, 4 here is the division result: " + division);
    }

        public static int calculate(MathOperator operator, int operand1, int operand2) {
            switch(operator) {
                case PLUS:
                    return operand1 + operand2;
                case MINUS:
                    return operand1 - operand2;
                case MULTIPLY:
                    return operand1 * operand2;
                case DIVIDE:
                    return operand1 / operand2;
                default:
                    throw new UnsupportedOperationException();
            }
        }

}
