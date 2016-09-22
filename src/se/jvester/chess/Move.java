package se.jvester.chess;

import se.jvester.chess.Board.Square;
import se.jvester.chess.Piece.Piece;

class Move {
    private Square origin;
    private Square target;
    private Player player;
    private Piece piece;

    public Move(Player player, Square origin, Square target) {
        this.player = player;
        this.origin = origin;
        this.target = target;

        getPieceFromOrigin();
    }

    public Square getOrigin() {
        return origin;
    }

    public Square getTarget() {
        return target;
    }

    public Player getPlayer() {
        return player;
    }

    public Piece getPiece() {
        return piece;
    }

    private void getPieceFromOrigin() {
        piece = origin.getPiece();
    }
}
