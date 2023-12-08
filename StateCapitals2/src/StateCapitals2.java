import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class StateCapitals2 {
    public static void main(String[] args) throws Exception{
        Map<String, String> stateCapital = new HashMap<>();
        String state, capital;

        Random randomizer = new Random();
        Scanner sc = new Scanner(new BufferedReader
                (new FileReader("StateCapitals.txt")));
        Scanner inputUser = new Scanner(System.in);

        System.out.println("50 STATES & CAPITALS ARE LOADED."); // 50 needs to be read from the HashMap
        System.out.println("=======");
        System.out.println("HERE ARE THE STATES :");

        // read the file line by line
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            //System.out.println(currentLine);

            // split the line by ::
            String[] parts = currentLine.split("::");
            //System.out.println(Arrays.toString(parts));

            // first part is state, second is capital
            state = parts[0].trim();
            System.out.print(state + " ");
            capital = parts[1].trim();

            // put state and capital in HashMap if they are empty
            if (!state.isEmpty() && !capital.isEmpty()) {
                stateCapital.put(state, capital);
            }
        }

        System.out.println();

        // get the Set of keys from the map
        Set<String> keys = stateCapital.keySet();
        // get the ArrayList of keys from the map
        List<String> states = new ArrayList<>(keys.size());


        for (String s : keys) {
            //System.out.println(s);
            states.add(s); //add an arrayList of only States
            //System.out.println(stateCapital.get(s));
        }
        // get a random state
        int randomNum = randomizer.nextInt(states.size());
        String randomState = states.get(randomNum);
        //System.out.println(randomNum);
        //System.out.println(randomState);


       // System.out.println(stateCapital.size());
        System.out.println("READY TO TEST YOUR KNOWLEDGE? WHAT IS THE CAPITAL OF '"
                + randomState + "'?");
        String answer = inputUser.nextLine();

        //System.out.println(stateCapital.get());
        for (String correctAnswer : keys) {
            if(answer.equals(stateCapital.get(correctAnswer))) {
                System.out.println("NICE WORK! " + correctAnswer + " IS CORRECT!");
            }
        }

    }
}

