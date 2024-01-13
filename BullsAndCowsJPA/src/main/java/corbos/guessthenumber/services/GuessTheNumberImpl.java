package corbos.guessthenumber.services;

import corbos.guessthenumber.dao.GameDao;
import corbos.guessthenumber.dao.RoundDao;
import corbos.guessthenumber.models.Game;
import corbos.guessthenumber.models.GameStatus;
import corbos.guessthenumber.models.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class GuessTheNumberImpl {

    // Helper method to calculate the result of a guess
    public String calculateResult(String answer, String guess) {
        // Initialize counts for exact and partial matches
        int exactMatches = 0;
        int partialMatches = 0;
        // Arrays to keep track of matched characters
        boolean[] answerMatched = new boolean[answer.length()];
        boolean[] guessMatched = new boolean[guess.length()];

        // Calculate exact matches
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess.charAt(i)) {
                exactMatches++;
                answerMatched[i] = true;
                guessMatched[i] = true;
            }
        }
        // Calculate partial matches
        for (int i = 0; i < answer.length(); i++) {
            for (int j = 0; j < guess.length(); j++) {
                if (!answerMatched[i] && !guessMatched[j] && answer.charAt(i) == guess.charAt(j)) {
                    partialMatches++;
                    answerMatched[i] = true;
                    guessMatched[j] = true;
                }
            }
        }
        // Return the result string
        return "e:" + exactMatches + ":p:" + partialMatches;
    }

    // Helper method to generate a random number to guess
    public String generateRandomNumber() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        Collections.shuffle(digits);

        StringBuilder randomNumber = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            randomNumber.append(digits.get(i));
        }
        return randomNumber.toString();
    }

}
