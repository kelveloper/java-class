import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class InterestCalculator {
    public void calculateInterest() {

        int annualInterestRate, years;
        double quarterlyInterestRate, principal;
        BigDecimal pr = null, currentBalance = null, interestPrincipal = null;
        Scanner sc = new Scanner(System.in);

        System.out.print("How much do you want to invest? ");
        principal = sc.nextDouble();
        System.out.print("How many years are investing? ");
        years = sc.nextInt();
        System.out.print("What is the annual interest rate % growth? ");
        annualInterestRate = sc.nextInt();

        quarterlyInterestRate =  (double) annualInterestRate / 4;


        System.out.println("Calculating...");
        for (int i = 1; i <= years; i++) {
            currentBalance = new BigDecimal(principal).setScale(2, RoundingMode.HALF_UP);
            int eachYear = i;
            System.out.println("Year " + eachYear + ":");
            for (int j = 1; j <= 4; j++) {
                principal =  principal * (1 + (quarterlyInterestRate / 100));
                pr = new BigDecimal(principal).setScale(2, RoundingMode.HALF_UP);
                // System.out.println(pr);
            }
            interestPrincipal = pr.subtract(currentBalance);
            System.out.println("Began with $" + currentBalance);
            System.out.println("Earned $" + interestPrincipal);
            System.out.println("Ended with $" + pr);
            System.out.println();
        }

    }
}
