package corbos.guessthenumber.data;

import corbos.guessthenumber.models.Game;
import corbos.guessthenumber.models.GameStatus;
import corbos.guessthenumber.models.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class GuessTheNumberMemoryDao implements GuessTheNumberDao{
    private final Map<Integer, Game> games = new HashMap<>();
    private final Map<Integer, List<Round>> roundsByGameId = new HashMap<>();
    private int gameIdSequence = 1;
    private int roundIdSequence = 1;

    @Override
    public Game saveGame(Game game) {
        game.setId(gameIdSequence++);
        games.put(game.getId(), game);
        roundsByGameId.put(game.getId(), new ArrayList<>());
        return game;
    }

    @Override
    public Game findGameById(int id) {
        return games.get(id);
    }

    @Override
    public Round saveRound(Round round) {
        round.setId(roundIdSequence++);
        List<Round> rounds = roundsByGameId.get(round.getGameId().getId());
        if (rounds != null) {
            rounds.add(round);
        }
        return round;
    }

    @Override
    public List<Round> findRoundsByGameId(int gameId) {
        return roundsByGameId.getOrDefault(gameId, new ArrayList<>());
    }

    private String generateRandomAnswer() {
        List<Integer> digits = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(digits);

        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            answerBuilder.append(digits.get(i));
        }

        return answerBuilder.toString();
    }

    private String calculateResult(String answer, String guess) {
        int exactMatches = 0;
        int partialMatches = 0;

        for (int i = 0; i < 4; i++) {
            char answerChar = answer.charAt(i);
            char guessChar = guess.charAt(i);

            if (answerChar == guessChar) {
                exactMatches++;
            } else if (answer.contains(String.valueOf(guessChar))) {
                partialMatches++;
            }
        }

        return "e:" + exactMatches + ":p:" + partialMatches;
    }
}
