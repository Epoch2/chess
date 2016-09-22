package se.jvester.chess.Board;

import java.lang.Math;

public class Position {
    private int rank;
    private int file;

    public Position(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public boolean isDiagonalTo(Position other) {
        return (getRank() != other.getRank() && file != other.getFile());
    }

    public Offset getOffsetTo(Position other) {
        int xOffset = other.getRank() - rank;
        int yOffset = other.getFile() - file;

        return new Offset(xOffset, yOffset);
    }

    public Distance getDistanceTo(Position other) {
        Offset offset = this.getOffsetTo(other);

        int xDistance = Math.abs(offset.getX());
        int yDistance = Math.abs(offset.getY());

        return new Distance(xDistance, yDistance);
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

    @Override
    public String toString() {
        return Integer.toString(rank) + ":" + Integer.toString(file);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Position other = (Position) obj;

        return rank == other.getRank() && file == other.getFile();
    }
}
