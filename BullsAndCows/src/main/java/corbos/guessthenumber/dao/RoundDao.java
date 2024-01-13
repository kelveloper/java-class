package corbos.guessthenumber.dao;

import corbos.guessthenumber.models.Round;

import java.util.List;
import java.util.Map;

public interface RoundDao {
    Round saveRound(Round round);
    List<Map<String, Object>> getRoundsForGame(int gameId);
    Round makeGuess(int gameId, String guess);
}
