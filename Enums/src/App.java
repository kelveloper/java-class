import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // ask to enter a day of the week
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter day of the week: ");
        String userInput = sc.nextLine();
        // // Convert user input to uppercase to handle case-insensitivity
        DaysOfTheWeek userDay = DaysOfTheWeek.valueOf(userInput.toUpperCase());
        int numOfDays = tillFriday(userDay);
        System.out.println("There are " + numOfDays + " days until Friday.");


//"3 more days until Friday."
//"It's Friday! Friday!"
        //"6 more days until Friday. :("
    }
// use a switch statement and your enum
// to print out how many days there are until Friday.
    private static int tillFriday (DaysOfTheWeek day) {
        int  numOfDaystilFriday;

        switch (day) {
            case SUNDAY:
                numOfDaystilFriday = 5;
                break;
            case MONDAY:
                numOfDaystilFriday = 4;
                break;
            case TUESDAY:
                numOfDaystilFriday = 3;
                break;
            case WEDNESDAY:
                numOfDaystilFriday = 2;
                break;
            case THURSDAY:
                numOfDaystilFriday = 1;
                break;
            case FRIDAY:
                numOfDaystilFriday = 0;
                break;
            case SATURDAY:
                numOfDaystilFriday = 6;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + day);
        }
        return numOfDaystilFriday;
    }
}



