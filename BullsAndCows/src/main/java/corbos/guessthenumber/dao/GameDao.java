package corbos.guessthenumber.dao;

import corbos.guessthenumber.models.Game;

import java.util.List;
import java.util.Map;

public interface GameDao {
    Game saveGame(Game game);
    Game findGameById(int id);
    List<Map<String, Object>> getAllGames();
    int startNewGame(Game game);
    Map<String, Object> getGameInfoById(int gameId);
}
