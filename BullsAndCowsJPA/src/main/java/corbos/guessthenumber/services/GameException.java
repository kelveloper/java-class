package corbos.guessthenumber.services;

public class GameException extends RuntimeException {

    public GameException(String message) {
        super(message);
    }

    public static class GameNotFoundException extends GameException {

        public GameNotFoundException(String message) {
            super(message);
        }
    }

    public static class InvalidGuessException extends GameException {

        public InvalidGuessException(String message) {
            super(message);
        }
    }
}