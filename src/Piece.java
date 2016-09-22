import java.util.List;

abstract public class Piece {
    private Color color;
    private Square square;
    private PieceMovement movement;

    public Piece(Color color, PieceMovement movement) {
        this.color = color;
        this.movement = movement;
    }

    public boolean isColor(Color color) {
        return this.color == color;
    }

    public Path getPathTo(Square target) {
        return movement.getPath(square.getPosition(), target.getPosition());
    }

    public boolean canMoveTo(Square target) {
        try {
            assertCanMoveTo(target);
        } catch (IllegalMoveException e) {
            return false;
        }

        return true;
    }

    public boolean canMoveTo(Piece piece) {
        return canMoveTo(piece.getSquare());
    }

    public void moveTo(Square target) throws IllegalMoveException {
        assertCanMoveTo(target);
        square = target;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public boolean isSameColorAs(Piece piece) {
        return color == piece.getColor();
    }

    public Color getColor() {
        return color;
    }

    public Square getSquare() {
        return square;
    }

    public boolean canNavigateFreely() {
        return false;
    }

    public String toString() {
        return color + " " + getClass().getName();
    }

    private void assertCanMoveTo(Square square) throws IllegalMoveException {
        Path pathToSquare = getPathTo(square);

        if (pathToSquare == null) {
            throw IllegalMoveException.noPathToSquare(this, square);
        }

        assertCanMoveToOccupiedSquare(square);
        assertCanNavigatePath(pathToSquare);
    }

    private void assertCanMoveToOccupiedSquare(Square square) throws IllegalMoveException {
        if (square.isOccupied()) {
            Piece pieceAlreadyInSquare = square.getPiece();
            if (pieceAlreadyInSquare.isSameColorAs(this)) throw IllegalMoveException.ownPieceCollision(this, pieceAlreadyInSquare, square);
        }
    }

    private void assertCanNavigatePath(Path path) throws IllegalMoveException {
        try {
            List<Position> nodes = path.getNodes();
            boolean pathIsEmpty = square.getBoard().getPiecesInPath(path).isEmpty();

            if (!pathIsEmpty && !canNavigateFreely()) {
                throw IllegalMoveException.pathBlocked(this, path);
            }
        } catch (OutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }
}
