/**
 * Created by jv on 21/09/16.
 *
 * OctagonalPieceMovement can navigate all 8 possible ways, and can be used with any piece that requires
 * movement in all directions, for example
 *  * Queen
 *  * King
 */
public class OctagonalPieceMovement implements PieceMovement {
    @Override
    public Path getPath(Position origin, Position target) {
        Path path = new Path();
        return path;
    }
}
