package se.jvester.chess.Piece;

import se.jvester.chess.Board.Square;
import se.jvester.chess.Color;
import se.jvester.chess.IllegalMoveException;
import se.jvester.chess.Piece.Movement.LimitedRangeMovement;
import se.jvester.chess.Piece.Movement.PieceMovement;

public class Pawn extends Piece {
    private static final int FIRST_MOVE_RANGE = 2;
    private static final int DEFAULT_MOVE_RANGE = 1;

    private boolean didMove = false;
    private boolean didSwapMovements = false;

    public Pawn(Color color, PieceMovement movement) {
        super(color, new LimitedRangeMovement(movement, FIRST_MOVE_RANGE));
    }

    @Override public void moveTo(Square square) throws IllegalMoveException {
        switchMovements();
        super.moveTo(square);
    }

    private void switchMovements() {
        if (didMove && !didSwapMovements) {
            ((LimitedRangeMovement) getMovement()).setMaxRange(DEFAULT_MOVE_RANGE);
            didSwapMovements = true;
        }
    }
}
