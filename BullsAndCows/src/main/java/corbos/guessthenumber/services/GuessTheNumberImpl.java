package corbos.guessthenumber.services;

import corbos.guessthenumber.data.GuessTheNumberDao;
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
public class GuessTheNumberImpl implements GuessTheNumberService {
    @Autowired
    private GuessTheNumberDao guessTheNumberDao;

    @Override
    public Round makeGuess(int gameId, String guess) {
        Game game = guessTheNumberDao.findGameById(gameId);

        if (game == null || game.getStatus() == GameStatus.FINISHED) {
            // Handle invalid game or already finished game
            return null;
        }

        // Perform game logic to calculate result
        String result = calculateResult(game.getAnswer(), guess);
        // System.out.println(game.getAnswer()); random generated number

        Round round = new Round();
        round.setGameId(gameId);
        round.setGuess(guess);
        round.setResult(result);
        round.setGuessTime(LocalDateTime.now()); // Set guessTime to the current time

        // Save the round
        guessTheNumberDao.saveRound(round);

        // Check if the guess is correct and update the game status
        if (result.equals("e:4:p:0")) {
            game.setStatus(GameStatus.FINISHED);
            guessTheNumberDao.saveGame(game);
        }
        // System.out.println(round.getGameId().getId()); Last print
        return round;
    }


    @Override
    public List<Map<String, Object>> getAllGames() {
        return guessTheNumberDao.getAllGames();
    }

    @Override
    public Game getGameById(int gameId) {
        Game game = guessTheNumberDao.findGameById(gameId);

        if (game != null) {
            Game simplifiedGame = new Game();
            simplifiedGame.setId(game.getId());
            simplifiedGame.setStatus(game.getStatus());
            return simplifiedGame;
        }

        return null; // or handle the case where the game is not found
    }

    @Override
    public List<Round> getRoundsByGameId(int gameId) {
        return guessTheNumberDao.findRoundsByGameId(gameId);
    }

    // Helper method to calculate the result of a guess
    private String calculateResult(String answer, String guess) {
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
