package corbos.guessthenumber.data;

import corbos.guessthenumber.models.Game;
import corbos.guessthenumber.models.Round;

import java.util.List;
import java.util.Map;

public interface GuessTheNumberDao {
    Game saveGame(Game game);

    Game findGameById(int id);

    Round saveRound(Round round);

    List<Round> findRoundsByGameId(int gameId);
    List<Map<String, Object>> getAllGames();

    List<Map<String, Object>> getRoundsForGame(int gameId);

    int startNewGame(Game game);
    Map<String, Object> getGameInfoById(int gameId);
}

