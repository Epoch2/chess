package se.jvester.chess.Piece.Movement;

/*
 *  FourWayPieceMovement will first navigate in a line along the X-axis, and then
 *  in a line along the Y-axis. This movement can be used with any piece that
 *  only requires straight movement along the X or Y axes, for example
 *
 *  * Pawn
 *  * Rook
 */

import se.jvester.chess.Board.Offset;
import se.jvester.chess.Board.Path;
import se.jvester.chess.Board.Position;

public class FourWayPieceMovement implements PieceMovement {
    @Override
    public Path getPath(Position origin, Position target) {
        Offset offset = origin.getOffsetTo(target);

        if (offset.isOnlyHorizontal()) {
            return getHorizontalPath(origin, target);
        } else if (offset.isOnlyVertical()) {
            return getVerticalPath(origin, target);
        }

        return null;
    }

    private Path getHorizontalPath(Position origin, Position target) {
        Path path = new Path();
        Offset offset = origin.getOffsetTo(target);

        int direction = Integer.signum(offset.getX());

        // We do not want to include our initial square
        int x = origin.getRank() + direction;

        for (; x != target.getRank(); x += direction) {
            Position node = new Position(x, origin.getFile());
            path.addNode(node);
        }

        return path;
    }

    private Path getVerticalPath(Position origin, Position target) {
        Path path = new Path();
        Offset offset = origin.getOffsetTo(target);

        int direction = Integer.signum(offset.getY());

        // We do not want to include our initial square
        int y = origin.getFile() + direction;

        for (; y != target.getFile(); y += direction) {
            Position node = new Position(origin.getRank(), y);
            path.addNode(node);
        }

        return path;
    }
}
