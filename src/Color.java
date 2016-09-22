public enum Color {
    WHITE, BLACK;

    public static Color invert(Color color) {
        if (color == WHITE) {
            return BLACK;
        }

        return WHITE;
    }
}
