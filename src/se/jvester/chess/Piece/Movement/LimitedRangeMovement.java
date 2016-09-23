package se.jvester.chess.Piece.Movement;

import se.jvester.chess.Board.Path;
import se.jvester.chess.Board.Position;

/**
 * Created by jv on 23/09/16.
 */
public class LimitedRangeMovement implements PieceMovement {
    private PieceMovement movement;
    private int maxRange;

    public LimitedRangeMovement(PieceMovement movement, int maxRange) {
        validateMaxRange(maxRange);
        this.movement = movement;
        this.maxRange = maxRange;
    }

    public void setMaxRange(int maxRange) {
        validateMaxRange(maxRange);
        this.maxRange = maxRange;
    }

    @Override
    public Path getPath(Position origin, Position destination) {
        Path path = movement.getPath(origin, destination);

        if (path != null && path.getNodeCount() > maxRange) {
            return null;
        }

        return path;
    }

    private void validateMaxRange(int maxRange) {
        if (maxRange < 0) {
            throw new IllegalArgumentException("maxRange cannot be less than 0");
        }
    }
}
