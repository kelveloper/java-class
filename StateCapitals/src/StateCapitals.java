import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StateCapitals {
    public static void main(String[] args) {
        Map<String, String> stateCapitals = new HashMap<>();

        // Load the HashMap with each state/capital pair
        stateCapitals.put("Alabama","Montgomery");
        stateCapitals.put("Alaska", "Juneau");
        stateCapitals.put("Arizona","Phoenix");
        stateCapitals.put("Arkansas","Little Rock");

        System.out.println("STATES: ");
        System.out.println("=======");
        // Print all of the state names to the screen.
        // 1. get the Set of keys from the map
        Set<String> keys = stateCapitals.keySet(); // import Set
        // 2. print the keys and associated values to the screen
        for (String s : keys) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("CAPITALS: ");
        System.out.println("=========");

        // 3. print the keys and associated values to the screen
        for (String c : keys) {
            System.out.println(stateCapitals.get(c));
        }

        System.out.println();
        System.out.println("STATE/CAPITAL PAIRS: ");
        System.out.println("====================");
        // 4. print each state along with its capital to the screen.
        for (String sc : keys) {
            System.out.println(sc + " - " + stateCapitals.get(sc));
        }
    }
}