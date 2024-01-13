package corbos.guessthenumber.dao;

import corbos.guessthenumber.models.Game;
import corbos.guessthenumber.models.GameStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GameDaoImpl implements GameDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public GameDaoImpl(JdbcTemplate jdbcTemplate) {
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

    private Game mapToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setId(rs.getInt("id")); // change this
        game.setAnswer(rs.getString("answer"));
        game.setStatus(GameStatus.valueOf(rs.getString("status")));
        return game;
    }
}
