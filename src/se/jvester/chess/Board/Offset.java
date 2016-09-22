package se.jvester.chess.Board;

public class Offset {
    private int x;
    private int y;

    public Offset(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isHorizontal() {
        return x != 0;
    }

    public boolean isVertical() {
        return y != 0;
    }

    public boolean isOnlyHorizontal() {
        return isHorizontal() && !isVertical();
    }

    public boolean isOnlyVertical() {
        return isVertical() && !isHorizontal();
    }

    /* Diagonal is defined as having an offset in both X and Y axes,
    NOT as an offset that is equal in both X and Y directions. */
    public boolean isDiagonal() {
        return isHorizontal() && isVertical();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return Integer.toString(x) + ":" + Integer.toString(y);
    }
}
