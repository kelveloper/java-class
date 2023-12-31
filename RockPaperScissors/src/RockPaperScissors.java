import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public void playGame() {
        int countTie = 0, countWin = 0, countLost = 0;
        int rounds, userChoice, aiChoice;
        String playAgain = "";
        Scanner sc = new Scanner(System.in);
        Random randomizer = new Random();
        // max game 10 and minimum 1, quit if error
        System.out.println("Let's play rock, paper, scissors!");

        do {
            System.out.print("How many rounds do you want to play? (MIN: 1, MAX: 10): ");
            rounds = sc.nextInt();

            if (rounds > 0 && rounds <= 10) {
                for (int i = 1; i <= rounds; i++) {
                    System.out.println("Choose! (1-3)");
                    System.out.println("1. Rock, 2. Paper, 3. Scissors");
                    userChoice = sc.nextInt();

                    aiChoice = randomizer.nextInt(1, 4); // start at 1 but bounds at 4 (4-1)
                    System.out.println(aiChoice);
                    // if statements to calculate who wins
                    if (userChoice == aiChoice) {
                        System.out.println("It a tie!");
                        countTie++;
                    } else if (userChoice == 1 && aiChoice == 3) {
                        System.out.println("You won!");
                        countWin++;
                    } else if (userChoice == 2 && aiChoice == 1) {
                        System.out.println("You won!");
                        countWin++;
                    } else if (userChoice == 3 && aiChoice == 2) {
                        System.out.println("You won!");
                        countWin++;
                    } else {
                        System.out.println("You lost!");
                        countLost++;
                    }
                }
                System.out.println("That's the end of the game. Here are the results:");
                System.out.println("Win: " + countWin);
                System.out.println("Lost: " + countLost);
                System.out.println("Tie: " + countTie);
                if (countWin > countLost) {
                    System.out.println("You won the game! Congrats fam. :)");
                } else if (countWin == countLost) {
                    System.out.println("Guess we are both losers... Darn.");
                } else System.out.println("Sorry. Looks like you've lost. Maybe next time bud.");

                System.out.print("Would you like to play again? (yes/no): ");
                playAgain = sc.next();

            } else System.out.println("Wrong input.");

        } while (playAgain.equals("yes"));

        System.out.println("Goodbye for now!");
    }
}
