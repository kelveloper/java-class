package corbos.guessthenumber.data;

import corbos.guessthenumber.models.Game;
import corbos.guessthenumber.models.GameStatus;
import corbos.guessthenumber.models.Round;
import corbos.guessthenumber.services.GuessTheNumberImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

@Repository
@Profile("database")
public class GuessTheNumberDatabaseDao implements GuessTheNumberDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private GuessTheNumberImpl guessTheNumberImpl;

    @Autowired
    public GuessTheNumberDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Game saveGame(Game game) {
        String sql = "INSERT INTO game (answer, status) VALUES (?, ?)";
        jdbcTemplate.update(sql, game.getAnswer(), game.getStatus().toString());
        return game; // You may return the updated game if needed
    }

    @Override
    public Game findGameById(int id) {
        String sql = "SELECT * FROM game WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapToGame, id);
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
    public List<Round> findRoundsByGameId(int gameId) {
        String sql = "SELECT * FROM round WHERE gameId = ? ORDER BY guessTime";
        return jdbcTemplate.query(sql, this::mapToRound, gameId);
    }

    private Game mapToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setId(rs.getInt("id")); // change this
        game.setAnswer(rs.getString("answer"));
        game.setStatus(GameStatus.valueOf(rs.getString("status")));
        return game;
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



    @Override
    public List<Map<String, Object>> getAllGames() {
        String sql = "SELECT id, status FROM game";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Map<String, Object> gameInfo = new HashMap<>();
            gameInfo.put("id", rs.getInt("id"));
            gameInfo.put("status", GameStatus.valueOf(rs.getString("status")).toString());
            return gameInfo;
        });
    }



    @Override
    public int startNewGame(Game game) {
        // Use GeneratedKeyHolder to obtain the generated key (auto-incremented ID)
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Save the game to the database and retrieve the generated key
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO game (answer, status) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, game.getAnswer());
            ps.setString(2, game.getStatus().toString());
            return ps;
        }, keyHolder);

        // Retrieve the generated key (auto-incremented ID)
        Number gameId = keyHolder.getKey();
        if (gameId != null) {
            game.setId(gameId.intValue());
        }

        // Return the generated gameId
        // System.out.println(game.getId());
        return game.getId();
    }
    public String generateRandomNumber() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        Collections.shuffle(digits);

        StringBuilder randomNumber = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            randomNumber.append(digits.get(i));
        }
        return randomNumber.toString();
    }

    @Override
    public Map<String, Object> getGameInfoById(int gameId) {
        String sql = "SELECT id, status FROM game WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Map<String, Object> gameInfo = new HashMap<>();
                gameInfo.put("id", rs.getInt("id"));
                gameInfo.put("status", GameStatus.valueOf(rs.getString("status")).toString());
                return gameInfo;
            }, gameId);
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where the game is not found
        }
    }
}

