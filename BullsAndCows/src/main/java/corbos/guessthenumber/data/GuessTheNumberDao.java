package corbos.guessthenumber.data;

import corbos.guessthenumber.models.Game;
import corbos.guessthenumber.models.Round;

import java.util.List;

public interface GuessTheNumberDao {
    Game saveGame(Game game);

    Game findGameById(int id);

    Round saveRound(Round round);

    List<Round> findRoundsByGameId(int gameId);
}

