package corbos.guessthenumber.dao;

import corbos.guessthenumber.models.Game;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GameDao {
    Game saveGame(Game game);
    Game findGameById(int id);
    List<Map<String, Object>> getAllGames();
    int startNewGame(Game game);
    Map<String, Object> getGameInfoById(int gameId);
}
