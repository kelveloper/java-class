package corbos.guessthenumber.dao;

import corbos.guessthenumber.models.Game;
import corbos.guessthenumber.models.GameStatus;
import corbos.guessthenumber.models.Round;
import corbos.guessthenumber.services.GuessTheNumberImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoundDaoImpl implements RoundDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private GameDao gameDao;
    @Autowired
    private GuessTheNumberImpl guessTheNumber;
    @Autowired
    public RoundDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Round saveRound(Round round) {
        String sql = "INSERT INTO round (gameId, guess, guessTime, result) VALUES (?, ?, ?, ?)";

        // Use GeneratedKeyHolder to obtain the generated key (auto-incremented ID)
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, round.getGameId());
            ps.setString(2, round.getGuess());
            ps.setTimestamp(3, Timestamp.valueOf(round.getGuessTime()));
            ps.setString(4, round.getResult());
            return ps;
        }, keyHolder);

        // Retrieve the generated key (auto-incremented ID)
        Number roundId = keyHolder.getKey();
        if (roundId != null) {
            round.setId(roundId.intValue());
        }

        return round;
    }

    @Override
    public List<Map<String, Object>> getRoundsForGame(int gameId) {
        String sql = "SELECT id, gameId, guess, guessTime, result FROM round WHERE gameId = ?";
        return jdbcTemplate.query(sql, new Object[]{gameId}, (rs, rowNum) -> {
            Map<String, Object> roundInfo = new HashMap<>();
            roundInfo.put("id", rs.getInt("id"));
            roundInfo.put("gameId", rs.getInt("gameId"));
            roundInfo.put("guess", rs.getString("guess"));
            roundInfo.put("guessTime", rs.getObject("guessTime", LocalDateTime.class));
            roundInfo.put("result", rs.getString("result"));
            return roundInfo;
        });
    }

    private Round mapToRound(ResultSet rs, int rowNum) throws SQLException {
        Round round = new Round();
        round.setId(rs.getInt("id"));

        // Assuming gameId in Round is of type Game
        Game game = new Game();
        game.setId(rs.getInt("gameId"));
        round.setGameId(game.getId()); // Set gameId directly without making another database call

        round.setGuess(rs.getString("guess"));
        round.setGuessTime(rs.getTimestamp("guessTime").toLocalDateTime());
        round.setResult(rs.getString("result"));
        return round;
    }

    @Override
    public Round makeGuess(int gameId, String guess) {
        Game game = gameDao.findGameById(gameId);

        if (game == null || game.getStatus() == GameStatus.FINISHED) {
            // Handle invalid game or already finished game
            return null;
        }

        // Perform game logic to calculate result
        String result = guessTheNumber.calculateResult(game.getAnswer(), guess);
        // System.out.println(game.getAnswer()); random generated number

        Round round = new Round();
        round.setGameId(gameId);
        round.setGuess(guess);
        round.setResult(result);
        round.setGuessTime(LocalDateTime.now()); // Set guessTime to the current time

        // Save the round
        saveRound(round);

        // Check if the guess is correct and update the game status
        if (result.equals("e:4:p:0")) {
            game.setStatus(GameStatus.FINISHED);
            gameDao.saveGame(game);
        }
        // System.out.println(round.getGameId().getId()); Last print
        return round;
    }
}
