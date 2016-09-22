import java.util.*;

abstract class Game {
    private Board board;
    private Color turn;
    private Map<Color, Player> players = new HashMap<>();
    private Map<Player, Boolean> check = new HashMap<>();
    private List<Move> moves = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public Game(Board board, Map<Color, Player> players) {
        this.board = board;
        this.players = players;
    }

    public void performMove(Move move) throws GameplayException {
        assertPlayerTurn(move);

        Square target = move.getTarget();
        Piece piece = move.getPiece();
        Piece previousPiece = target.getPiece();

        piece.moveTo(target);
        capturePiece(previousPiece);
        check(piece);
    }

    public Color getTurn() {
        return turn;
    }

    public List<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    protected Board getBoard() {
        return board;
    }

    protected boolean isChecked(Color color) {
        return check.get(color);
    }

    protected Player getPlayerByColor(Color color) {
        return players.get(color);
    }

    protected Player getPlayerByPiece(Piece piece) {
        return getPlayerByColor(piece.getColor());
    }

    protected void swapTurns() {
        setTurn(Color.invert(turn));
    }

    protected void setTurn(Color color) {
        turn = color;
    }

    protected Collection<Player> getPlayers() {
        return players.values();
    }

    private void capturePiece(Piece piece) {
        if (piece != null) {
            capturedPieces.add(piece);
        }
    }

    private void assertPlayerTurn(Move move) throws GameplayException {
        Player player = move.getPlayer();

        if (player != getPlayerByColor(turn)) {
            throw GameplayException.notPlayerTurn(player);
        }
    }

    private void check(Piece piece) throws GameplayException {
        Color otherColor = Color.invert(piece.getColor());
        King otherKing = board.getKing(otherColor);

        if (piece.canMoveTo(otherKing)) {
            check.put(otherColor, true);
        }
    }
}
