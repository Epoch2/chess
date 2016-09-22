package se.jvester.chess.Board;

public class Offset {
    private int x;
    private int y;

    public Offset(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOnlyHorizontal() {
        return x != 0 && y == 0;
    }

    public boolean isOnlyVertical() {
        return y != 0 && x == 0;
    }

    public boolean isDiagonal() {
        return x != 0 && y != 0;
    }

    public String toString() {
        return Integer.toString(x) + ":" + Integer.toString(y);
    }
}
