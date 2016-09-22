import java.util.HashMap;
import java.util.Map;

public class ClassicGameTest {
    public static void main(String[] args) throws GameplayException {
        Board board = new Board(8);

        Map<Color, Player> players = new HashMap<>();
        Player white = new Player();
        Player black = new Player();

        players.put(Color.WHITE, white);
        players.put(Color.BLACK, black);

        Game game = new ClassicGame(board, players);
        Square from = game.getBoard().getSquareAt(new Position(0, 0));
        Square to = game.getBoard().getSquareAt(new Position(0, 1));

        Piece piece = from.getPiece();

        Move move = new Move(white, from, to);

        try {
            game.performMove(move);
        } catch (IllegalMoveException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(piece.getSquare() == to);
        System.out.println(game.getCapturedPieces());
    }
}
