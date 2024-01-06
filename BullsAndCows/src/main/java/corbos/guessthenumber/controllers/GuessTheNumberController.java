package corbos.guessthenumber.controllers;

import corbos.guessthenumber.models.Game;
import corbos.guessthenumber.models.Round;
import corbos.guessthenumber.services.GuessTheNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guess-the-number")
public class GuessTheNumberController {
    @Autowired
    private GuessTheNumberService guessTheNumberService;

    @PostMapping("/begin")
    public int beginGame() {
        return guessTheNumberService.startNewGame();
    }

    @PostMapping("/guess/{gameId}")
    public Round makeGuess(@PathVariable int gameId, @RequestBody String guess) {
        return guessTheNumberService.makeGuess(gameId, guess);
    }

    @GetMapping("/game/{gameId}")
    public Game getGame(@PathVariable int gameId) {
        return guessTheNumberService.getGameById(gameId);
    }

    @GetMapping("/rounds/{gameId}")
    public List<Round> getRounds(@PathVariable int gameId) {
        return guessTheNumberService.getRoundsByGameId(gameId);
    }
}

