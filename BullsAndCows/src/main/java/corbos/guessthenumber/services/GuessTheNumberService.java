package corbos.guessthenumber.services;

import corbos.guessthenumber.models.Game;
import corbos.guessthenumber.models.Round;

import java.util.List;

public interface GuessTheNumberService {
    int startNewGame();

    Round makeGuess(int gameId, String guess);

    Game getGameById(int gameId);

    List<Round> getRoundsByGameId(int gameId);
}
