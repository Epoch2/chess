import java.util.Optional;

class Pawn extends Piece {
    private Optional<Integer> orientation;

    public Pawn(Color color, PieceMovement movement) {
        super(color, movement);
    }

    @Override
    public boolean canMoveTo(Square target) {
        // Make sure we only move forwards
        if (orientation.isPresent()) {
            int desiredDirection = target.getOffsetFrom(getSquare()).getY();

            if (desiredDirection != orientation.get()) {
                return false;
            }
        }

        return super.canMoveTo(target);
    }

    @Override
    public void moveTo(Square target) {
        if (!orientation.isPresent()) {
            orientation = Optional.of(target.getOffsetFrom(getSquare()).getY());
        }
    }
}
