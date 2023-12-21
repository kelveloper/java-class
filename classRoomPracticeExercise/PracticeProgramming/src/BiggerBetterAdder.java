import java.util.Scanner;

public class BiggerBetterAdder {
    public static void main(String[] args) {
        int a, b, c, sum;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("First number: ");
        String input1 = inputReader.nextLine();
        a = Integer.parseInt(input1);

        System.out.println("Second number: ");
        String input2 = inputReader.nextLine();
        b = Integer.parseInt(input2);

        System.out.println("Third number: ");
        String input3 = inputReader.nextLine();
        c = Integer.parseInt(input3);

        sum = a + b + c;

        System.out.println(a + " + " + b + " + " + c + " = " + sum);
    }
}
