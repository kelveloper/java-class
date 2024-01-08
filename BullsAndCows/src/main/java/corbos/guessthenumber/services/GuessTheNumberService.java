package corbos.guessthenumber.services;

import corbos.guessthenumber.models.Game;
import corbos.guessthenumber.models.Round;

import java.util.List;
import java.util.Map;

public interface GuessTheNumberService {

    Round makeGuess(int gameId, String guess);
    List<Map<String, Object>> getAllGames();

    Game getGameById(int gameId);

    List<Round> getRoundsByGameId(int gameId);

}
