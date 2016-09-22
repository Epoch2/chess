package se.jvester.chess;

import se.jvester.chess.Board.Path;
import se.jvester.chess.Board.Square;
import se.jvester.chess.Piece.Piece;

public class IllegalMoveException extends GameplayException {
    private Piece piece;

    public IllegalMoveException(String message) {
        super(message);
    }

    public static IllegalMoveException noPathToSquare(Piece piece, Square target) {
        String message = pieceToString(piece) + " can not generate a path to " + target;

        return new IllegalMoveException(message);
    }

    public static IllegalMoveException ownPieceCollision(Piece pieceMoved, Piece collidedWith, Square square) {
        String message = pieceToString(pieceMoved) + " cannot move to square " + square + ", " + pieceToString(collidedWith) + " is already there.";

        return new IllegalMoveException(message);
    }

    public static IllegalMoveException pathBlocked(Piece piece, Path path) {
        String message = pieceToString(piece) + " cannot navigate path " + path + ", one or more pieces are in the way.";

        return new IllegalMoveException(message);
    }

    public static IllegalMoveException nothingToCapture(Square square) {
        String message = "Cannot capture " + square + ", square is unoccupied.";

        return new IllegalMoveException(message);
    }

    private static String pieceToString(Piece piece) {
        return piece + " at " + piece.getSquare();
    }
}
