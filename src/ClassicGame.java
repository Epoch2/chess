import java.util.Optional;
import java.util.Map;

class ClassicGame extends Game {
    public ClassicGame(Board board, Map<Color, Player> players) {
        super(board, players);

        setTurn(Color.WHITE);
        generatePieces();
    }

    @Override
    public void performMove(Move move) throws GameplayException {
        assertPlayerOwnsPiece(move);
        assertPlayerHandlesCheck(move);
        assertKingDoesntCheckSelf(move);

        super.performMove(move);
    }

    private void assertPlayerHandlesCheck(Move move) throws IllegalMoveException {
    }

    private void assertKingDoesntCheckSelf(Move move) throws IllegalMoveException {
        Piece piece = move.getPiece();
        Square target = move.getTarget();

        if (piece instanceof King) {
            Optional<Piece> pieceThatWillCheck = getBoard().getPieces().stream().filter(p -> p.canMoveTo(target)).findAny();

            if (pieceThatWillCheck.isPresent()) {
                throw new IllegalMoveException("Cannot move King into checked position!");
            }
        }
    }

    private void assertPlayerOwnsPiece(Move move) throws IllegalMoveException {
        if (move.getPlayer() != getPlayerByColor(move.getPiece().getColor())) {
            throw new IllegalMoveException("Cannot move opponents piece!");
        }
    }

    private void generatePieces() {
        Piece rook = new Rook(Color.WHITE, new FourWayPieceMovement());
        Piece blackRook = new Rook(Color.BLACK, new FourWayPieceMovement());

        try {
            getBoard().addPiece(rook, new Position(0, 0));
            getBoard().addPiece(blackRook, new Position(0, 1));
        } catch (GameplayException e) {
            System.err.println(e.getMessage());
        }
    }
}
