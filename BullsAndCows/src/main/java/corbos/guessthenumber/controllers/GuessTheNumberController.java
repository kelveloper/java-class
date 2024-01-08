package corbos.guessthenumber.controllers;

import corbos.guessthenumber.data.GuessTheNumberDao;
import corbos.guessthenumber.models.Game;
import corbos.guessthenumber.models.GameStatus;
import corbos.guessthenumber.models.Round;
import corbos.guessthenumber.services.GameException;
import corbos.guessthenumber.services.GuessTheNumberImpl;
import corbos.guessthenumber.services.GuessTheNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/guess-the-number")
public class GuessTheNumberController {
    @Autowired
    private GuessTheNumberService guessTheNumberService;
    @Autowired
    private GuessTheNumberDao guessTheNumberDao;
    @Autowired
    private GuessTheNumberImpl guessTheNumberImpl;


    @PostMapping("/begin")
    public ResponseEntity<String> beginGame() {
        // Create a new game
        Game newGame = new Game();

        // Generate a random answer using GuessTheNumberImpl
        String randomAnswer = guessTheNumberImpl.generateRandomNumber();

        // Set the answer and status
        newGame.setAnswer(randomAnswer);
        newGame.setStatus(GameStatus.IN_PROGRESS);

        // Save the game to the database
        int gameId = guessTheNumberDao.startNewGame(newGame);

        // Print out the answer and status for debugging/logging
        System.out.println("GameId: " + gameId);
        System.out.println("Answer: " + newGame.getAnswer());
        System.out.println("Status: " + newGame.getStatus());

        // Return only the status as a string and a 201 CREATED status
        return new ResponseEntity<>(newGame.getStatus().toString(), HttpStatus.CREATED);
    }
    @PostMapping("/guess")
    public ResponseEntity<?> makeGuess(@RequestBody Map<String, Object> guessRequest) {
        try {
            int gameId = (int) guessRequest.get("gameId");
            String guess = (String) guessRequest.get("guess");

            Round round = guessTheNumberImpl.makeGuess(gameId, guess);

            return ResponseEntity.ok(round);
        } catch (GameException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/game")
    public ResponseEntity<List<Map<String, Object>>> getAllGames() {
        List<Map<String, Object>> gamesInfo = guessTheNumberService.getAllGames();
        return new ResponseEntity<>(gamesInfo, HttpStatus.OK);
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<Map<String, Object>> getGameById(@PathVariable int gameId) {
        Map<String, Object> gameInfo = guessTheNumberDao.getGameInfoById(gameId);

        if (gameInfo != null) {
            return new ResponseEntity<>(gameInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/rounds/{gameId}")
    public ResponseEntity<List<Round>> getRoundsForGame(@PathVariable int gameId) {
        List<Map<String, Object>> roundInfoList = guessTheNumberDao.getRoundsForGame(gameId);
        List<Round> rounds = new ArrayList<>();

        for (Map<String, Object> roundInfo : roundInfoList) {
            Round round = new Round();
            round.setId((int) roundInfo.get("id"));
            round.setGameId((int) roundInfo.get("gameId"));
            round.setGuess((String) roundInfo.get("guess"));
            round.setGuessTime((LocalDateTime) roundInfo.get("guessTime"));
            round.setResult((String) roundInfo.get("result"));
            rounds.add(round);
        }

        return new ResponseEntity<>(rounds, HttpStatus.OK);
    }

}


