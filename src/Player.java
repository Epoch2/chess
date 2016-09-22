import java.util.Collection;

class Player {
    private Collection<Piece> capturedPieces;

    public void capturePiece(Piece piece) {
        capturedPieces.add(piece);
    }
}
