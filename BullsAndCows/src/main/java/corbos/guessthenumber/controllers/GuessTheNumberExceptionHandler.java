package corbos.guessthenumber.controllers;

import corbos.guessthenumber.services.GameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GuessTheNumberExceptionHandler {

    @ExceptionHandler(GameException.class)
    public ResponseEntity<String> handleGameException(GameException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
