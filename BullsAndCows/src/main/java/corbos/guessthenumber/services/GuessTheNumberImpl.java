package corbos.guessthenumber.services;

import corbos.guessthenumber.data.GuessTheNumberDao;
import corbos.guessthenumber.models.Game;
import corbos.guessthenumber.models.GameStatus;
import corbos.guessthenumber.models.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GuessTheNumberImpl implements GuessTheNumberService {
    @Autowired
    private GuessTheNumberDao guessTheNumberDao;

    @Override
    public int startNewGame() {
        Game newGame = new Game();
        newGame.setStatus(GameStatus.IN_PROGRESS);
        Game savedGame = guessTheNumberDao.saveGame(newGame);
        return savedGame.getId();
    }

    @Override
    public Round makeGuess(int gameId, String guess) {
        Game game = guessTheNumberDao.findGameById(gameId);

        if (game == null || game.getStatus() == GameStatus.FINISHED) {
            // Handle invalid game or already finished game
            return null;
        }

        // Perform game logic to calculate result
        String result = calculateResult(game.getAnswer(), guess);

        // Create a new round
        Round round = new Round();
        round.setGameId(game);
        round.setGuess(guess);
        round.setResult(result);

        // Save the round
        guessTheNumberDao.saveRound(round);

        // Check if the guess is correct and update the game status
        if (result.equals("e:4:p:0")) {
            game.setStatus(GameStatus.FINISHED);
            guessTheNumberDao.saveGame(game);
        }

        return round;
    }

    @Override
    public Game getGameById(int gameId) {
        return guessTheNumberDao.findGameById(gameId);
    }

    @Override
    public List<Round> getRoundsByGameId(int gameId) {
        return guessTheNumberDao.findRoundsByGameId(gameId);
    }

    // Helper method to calculate the result of a guess
    private String calculateResult(String answer, String guess) {
        // Implement your logic to calculate the result (exact and partial matches)
        // For demonstration, a simple result is returned. Replace this with your actual logic.
        return "e:0:p:0";
    }
}
