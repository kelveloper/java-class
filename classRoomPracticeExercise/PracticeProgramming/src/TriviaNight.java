<<<<<<< HEAD
import java.util.Scanner;

public class TriviaNight {
    public static void main(String[] args) {
        int answer1, answer2, answer3;
        int sum = 0;
        String input1, input2, input3;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("It's TRIVIA NIGHT! Are you ready?!");
        System.out.println();

        System.out.println("FIRST QUESTION!");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Source Code      2) Assembly Language");
        System.out.println("3) C#               4) Machine Code");
        System.out.println("YOUR ANSWER: ");
        input1 = inputReader.nextLine();
        answer1 = Integer.parseInt(input1);

        if( answer1 == 4) {
            sum++;
        }

        System.out.println();
        System.out.println("SECOND QUESTION!");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper         2) Alan Turing");
        System.out.println("3) Charles Babbage      4) Larry Page");
        System.out.println("YOUR ANSWER: ");
        input2 = inputReader.nextLine();
        answer2 = Integer.parseInt(input2);

        if( answer2 == 2) {
            sum++;
        }

        System.out.println();
        System.out.println("LAST QUESTION!");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity             2) The Battlestar Galactica");
        System.out.println("3) The USS Enterprise   4) The Millennium Falcon");
        System.out.println("YOUR ANSWER: ");
        input3 = inputReader.nextLine();
        answer3 = Integer.parseInt(input3);

        if( answer3 == 3) {
            sum++;
        }

        System.out.println();
        System.out.println("Nice job - you got " + sum + " correct!");
    }
}
=======
import java.util.Scanner;

public class TriviaNight {
    public static void main(String[] args) {
        int answer1, answer2, answer3;
        int sum = 0;
        String input1, input2, input3;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("It's TRIVIA NIGHT! Are you ready?!");
        System.out.println();

        System.out.println("FIRST QUESTION!");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Source Code      2) Assembly Language");
        System.out.println("3) C#               4) Machine Code");
        System.out.println("YOUR ANSWER: ");
        input1 = inputReader.nextLine();
        answer1 = Integer.parseInt(input1);

        if( answer1 == 4) {
            sum++;
        }

        System.out.println();
        System.out.println("SECOND QUESTION!");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper         2) Alan Turing");
        System.out.println("3) Charles Babbage      4) Larry Page");
        System.out.println("YOUR ANSWER: ");
        input2 = inputReader.nextLine();
        answer2 = Integer.parseInt(input2);

        if( answer2 == 2) {
            sum++;
        }

        System.out.println();
        System.out.println("LAST QUESTION!");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity             2) The Battlestar Galactica");
        System.out.println("3) The USS Enterprise   4) The Millennium Falcon");
        System.out.println("YOUR ANSWER: ");
        input3 = inputReader.nextLine();
        answer3 = Integer.parseInt(input3);

        if( answer3 == 3) {
            sum++;
        }

        System.out.println();
        System.out.println("Nice job - you got " + sum + " correct!");
    }
}
>>>>>>> 6a51527984e9c113aa8e3981d95c1f1168074c88
