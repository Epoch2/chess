package se.jvester.chess;

import se.jvester.chess.Board.Position;

/**
 * Created by jv on 22/09/16.
 */
public class OutOfBoundsException extends GameplayException {
    public OutOfBoundsException(Position position) {
        super("Out of bounds: " + position);
    }
}
