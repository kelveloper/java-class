<<<<<<< HEAD
import java.util.Scanner;

public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        System.out.println("How many units of fizzing and buzzing do you need in your life?");
        Scanner inputReader = new Scanner(System.in);
        String str = inputReader.nextLine();
        int max = Integer.parseInt(str);
        int count = 0;

        for (int number = 0; count <= max; number++) {
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("fizz buzz");
                count++;
            } else if (number % 3 == 0) {
                System.out.println("fizz");
                count++;
            } else if (number % 5 == 0) {
                System.out.println("buzz");
                count++;
            } else {
                System.out.println(number);
            }
        }

        System.out.println("TRADITION!!");
    }
}

/*
for(count=0, theNumber=0; count < userLimit; theNumber++) {
    // print the number
    // iff theNumber % 3
            say fizz
            count++
       else if it's % 5 say buzz
            count++
       else if it's % 7 say fizz buzz
            count++
       else print the number
 }
 */

/* ---THIS IS THE WHILE LOOP WAY---
import java.util.Scanner;

public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        System.out.println("Give me a number!");
        Scanner inputReader = new Scanner(System.in);
        String str = inputReader.nextLine();
        int max = Integer.parseInt(str);
        int number = 0;
        int count =0;
        while (count <=  max){
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("fizz buzz");
                count++;
            }
            else if (number % 3 == 0) {
                System.out.println("fizz");
                count++;
            } else if (number % 5 == 0) {
                System.out.println("buzz");
                count++;
            } else {
                System.out.println(number);
            }
            number++;
        }
        System.out.println("TRADITON!!");
    }
}

=======
import java.util.Scanner;

public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        System.out.println("How many units of fizzing and buzzing do you need in your life?");
        Scanner inputReader = new Scanner(System.in);
        String str = inputReader.nextLine();
        int max = Integer.parseInt(str);
        int count = 0;

        for (int number = 0; count <= max; number++) {
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("fizz buzz");
                count++;
            } else if (number % 3 == 0) {
                System.out.println("fizz");
                count++;
            } else if (number % 5 == 0) {
                System.out.println("buzz");
                count++;
            } else {
                System.out.println(number);
            }
        }

        System.out.println("TRADITION!!");
    }
}

/*
for(count=0, theNumber=0; count < userLimit; theNumber++) {
    // print the number
    // iff theNumber % 3
            say fizz
            count++
       else if it's % 5 say buzz
            count++
       else if it's % 7 say fizz buzz
            count++
       else print the number
 }
 */

/* ---THIS IS THE WHILE LOOP WAY---
import java.util.Scanner;

public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        System.out.println("Give me a number!");
        Scanner inputReader = new Scanner(System.in);
        String str = inputReader.nextLine();
        int max = Integer.parseInt(str);
        int number = 0;
        int count =0;
        while (count <=  max){
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("fizz buzz");
                count++;
            }
            else if (number % 3 == 0) {
                System.out.println("fizz");
                count++;
            } else if (number % 5 == 0) {
                System.out.println("buzz");
                count++;
            } else {
                System.out.println(number);
            }
            number++;
        }
        System.out.println("TRADITON!!");
    }
}

>>>>>>> 6a51527984e9c113aa8e3981d95c1f1168074c88
 */