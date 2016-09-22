package se.jvester.chess.Board;

import java.util.*;
import se.jvester.chess.*;
import se.jvester.chess.Piece.King;
import se.jvester.chess.Piece.Piece;

public class Board {
    private int dimension;
    private Map<Position, Square> squares = new HashMap<>();

    public Board(int dimension) {
        this.dimension = dimension;
        generateSquares();
    }

    public void addPiece(Piece piece, Position position) throws GameplayException {
        Square square = getSquareAt(position);

        if (square.isOccupied()) {
            throw new GameplayException("A piece is already occupying square " + square);
        }

        square.setPiece(piece);
    }

    public King getKing(Color color) throws GameplayException {
        Optional<Piece> king = getPieces().stream().filter(p -> p instanceof King && p.isColor(color)).findAny();

        if (!king.isPresent()) {
            throw GameplayException.noKingForColor(color);
        }

        return (King) king.get();
    }

    public Square getSquareAt(Position position) throws OutOfBoundsException {
        Square square = squares.get(position);

        if (square == null) {
            throw new OutOfBoundsException(position);
        }

        return square;
    }

    public boolean hasSquareAt(Position position) {
        return squares.containsKey(position);
    }

    public List<Square> getSquaresInPath(Path path) throws OutOfBoundsException {
        List<Square> squaresInPath = new ArrayList<>();

        for (Position node : path.getNodes()) {
            squaresInPath.add(getSquareAt(node));
        }

        return squaresInPath;
    }

    public Collection<Piece> getPiecesInPath(Path path) throws OutOfBoundsException {
        Collection<Piece> pieces = new ArrayList<>();
        List<Square> squaresInPath = getSquaresInPath(path);

        for (Square square : squaresInPath) {
            if (square.isOccupied()) {
                pieces.add(square.getPiece());
            }
        }

        return pieces;
    }

    public Collection<Square> getSquares() {
        return squares.values();
    }

    public Collection<Piece> getPieces() {
        Collection<Piece> pieces = new ArrayList<>();

        for (Square square : squares.values()) {
            if (square.isOccupied()) {
                pieces.add(square.getPiece());
            }
        }

        return pieces;
    }

    private void generateSquares() {
        for (int rank = 0; rank < dimension; rank++) {
            String rankName = getNameForRank(rank);

            for (int file = 0; file < dimension; file++) {
                String fileName = getNameForFile(file);
                String squareName = rankName + fileName;

                Position position = new Position(rank, file);
                Square square = new Square(this, position, squareName);

                squares.put(position, square);
            }
        }
    }

    private String getNameForRank(int rank) {
        return getCharForNumber(rank);
    }

    private String getNameForFile(int file) {
        return Integer.toString(file + 1);
    }

    private String getCharForNumber(int i) {
        return i > -1 && i < 26 ? String.valueOf((char)(i + 65)) : null;
    }
}
