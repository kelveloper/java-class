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

      //  System.out.println(sc.length() +" STATES & CAPITALS ARE LOADED.");
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
        List<String> st = new ArrayList<>(keys.size());


        for (String s : keys) {
            //System.out.println(s);
            st.add(s);
            //System.out.println(st);

        }
        int randomState = randomizer.nextInt(st.size());
        System.out.println(randomState);
        

       // System.out.println(stateCapital.size());
        System.out.println("READY TO TEST YOUR KNOWLEDGE? WHAT IS THE CAPITAL OF 'Alaska'?");
        }

}

