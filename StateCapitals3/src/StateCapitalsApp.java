import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.*;

public class StateCapitalsApp {
    public static void main(String[] args) throws Exception {

        Map<String, Capital> stateCapital = new HashMap<>();
        String state;
        Random randomizer = new Random();
        Scanner inputUser = new Scanner(System.in);
        Scanner sc = new Scanner(new BufferedReader
                (new FileReader("MoreStateCapitals.txt")));
        Scanner userInput = new Scanner(System.in); // to read only inputs

        // read the file line by line
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();

            // split the line by ::
            String[] parts = currentLine.split("::");

            state = parts[0].trim();
            // create a capital object
            Capital capital = new Capital();
            capital.setName(parts[1].trim());
            // System.out.println(capital.getName());
            capital.setPopulation(Integer.parseInt(parts[2].trim()));
            capital.setSquareMileage(Double.parseDouble(parts[3].trim()));

            // Add the state-capital pair to the HashMap
            stateCapital.put(state, capital);
        }

        System.out.println(stateCapital.size() + " STATES & CAPITALS ARE LOADED."); // 50 needs to be read from the HashMap
        System.out.println("================================");
        System.out.println();

        for (String s : stateCapital.keySet()) {
            Capital capital = stateCapital.get(s);
            System.out.println(s + capital);
        }
        // prompt the user for a population limit
        System.out.println();
        System.out.print("Please enter the lower limit for capital city population: ");
        int popLimit = userInput.nextInt();

        System.out.println();
        System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + popLimit + ":");
        System.out.println();

        for (String s : stateCapital.keySet()) {
            Capital capital = stateCapital.get(s);
            if (capital.getPopulation() > popLimit) {
                System.out.println(s + capital);
            }
        }

        System.out.println();
        System.out.println("Please enter the upper limit for capital city sq mileage: ");
        int sqMileLimit = userInput.nextInt();
        System.out.println();

        System.out.println("LISTING CAPITALS WITH AREAS LESS THAN " + sqMileLimit + ":");
        for (String s : stateCapital.keySet()) {
            Capital capital = stateCapital.get(s);
            if (capital.getSquareMileage() < sqMileLimit) {
                System.out.println(s + capital);
            }
        }

    }

}