package se.jvester.chess;

import se.jvester.chess.Board.Position;

public class OutOfBoundsException extends GameplayException {
    public OutOfBoundsException(Position position) {
        super("Out of bounds: " + position);
    }
}
