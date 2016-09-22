package se.jvester.chess;

public class GameplayException extends Exception {
    public GameplayException(String message) {
        super(message);
    }

    public static GameplayException notPlayerTurn(Player player) {
        String message = "The turn does not belong to player " + player;

        return new GameplayException(message);
    }

    public static GameplayException noKingForColor(Color color) {
        String message = "Could not find a king for player with color " + color;

        return new GameplayException(message);
    }
}
