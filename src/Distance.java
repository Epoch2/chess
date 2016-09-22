public class Distance {
    private int x;
    private int y;

    public Distance(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Distance cannot be negative!");
        }

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean zero() {
        return x + y == 0;
    }
}
