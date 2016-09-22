package se.jvester.chess.Pieces.Movement;

import se.jvester.chess.Board.Path;
import se.jvester.chess.Board.Position;

public interface PieceMovement {
    Path getPath(Position origin, Position target);
}
