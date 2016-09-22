package se.jvester.chess.Board;

import java.lang.Math;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isDiagonalTo(Position position) {
        return (getX() != position.getX() && y != position.getY());
    }

    public Offset getOffsetTo(Position position) {
        int xOffset = position.getX() - x;
        int yOffset = position.getY() - y;

        return new Offset(xOffset, yOffset);
    }

    public Distance getDistanceTo(Position other) {
        Offset offset = this.getOffsetTo(other);

        int xDistance = Math.abs(offset.getX());
        int yDistance = Math.abs(offset.getY());

        return new Distance(xDistance, yDistance);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return Integer.toString(x) + ":" + Integer.toString(y);
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

        Position position = (Position) obj;

        return x == position.getX() && y == position.getY();
    }
}
