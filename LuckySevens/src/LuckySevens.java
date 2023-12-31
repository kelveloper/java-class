import java.util.Random;
import java.util.Scanner;

public class LuckySevens {
    public void seven() {

        int userMoney, dieOne, dieTwo, sum, countRolls = 0, maxAmount = 0, countRollsWhenMax = 0;

        // need two dice that chooses randomly from 1-6
        Random randomizer = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many dollars do you have? (dollars) ");
        userMoney = sc.nextInt();

        while (userMoney > 0) {
            dieOne = randomizer.nextInt(6 - 1) + 1;
            dieTwo = randomizer.nextInt(6 - 1) + 1;
            sum = dieOne + dieTwo;
            if (sum == 7) {
                if (maxAmount < userMoney) {
                    maxAmount = userMoney;
                    countRollsWhenMax = countRolls;
                }
                userMoney += 4;
            }
            countRolls++;
            userMoney--;
        }

        System.out.println("You are broke after " + countRolls + " rolls.");
        System.out.println("You should have quit after " + countRollsWhenMax
                + " rolls when you had $" + maxAmount);

    }
}
