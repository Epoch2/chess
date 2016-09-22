package se.jvester.chess.Board;

import java.util.*;
import java.util.stream.Collectors;

import se.jvester.chess.*;
import se.jvester.chess.Piece.King;
import se.jvester.chess.Piece.Piece;

public class Board {
    private Map<Position, Square> squares = new HashMap<>();

    public Board(int ranks, int files) {
        generateSquares(ranks, files);
    }

    public void addPiece(Piece piece, Position position) throws GameplayException {
        Square square = getSquareAt(position);

        if (square.isOccupied()) {
            throw new GameplayException("A piece is already occupying square " + square);
        }

        square.setPiece(piece);
    }

    public King getKing(Color color) throws GameplayException {
        Optional<Piece> king = getPieces().stream()
                .filter(p -> p instanceof King && p.isColor(color))
                .findAny();

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
        List<Square> squaresInPath = getSquaresInPath(path);

        return getPiecesFromSquares(squaresInPath);
    }

    public Collection<Square> getSquares() {
        return squares.values();
    }

    public Collection<Piece> getPieces() {
        return getPiecesFromSquares(squares.values());
    }

    private void generateSquares(int ranks, int files) {
        for (int rank = 0; rank < ranks; rank++) {
            String rankName = getNameForRank(rank);

            for (int file = 0; file < files; file++) {
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

    private Collection<Piece> getPiecesFromSquares(Collection<Square> squares) {
        return squares.stream()
                .filter(s -> s.isOccupied())
                .map(s -> s.getPiece())
                .collect(Collectors.toList());
    }
}
