public class Square {
    String name;
    Board board;
    Position position;
    Piece piece;

    public Square(Board board, Position position, String name) {
        this.board = board;
        this.position = position;
        this.name = name;
    }

    public boolean isDiagonalTo(Square square) {
        return position.isDiagonalTo(square.getPosition());
    }

    public Offset getOffsetFrom(Square other) {
        return position.getOffsetTo(other.getPosition());
    }

    public Distance getDistanceTo(Square other) {
        return position.getDistanceTo(other.getPosition());
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public Board getBoard() {
        return board;
    }

    public Position getPosition() {
        return position;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        piece.setSquare(this);
    }

    public String toString() {
        return name;
    }
}
