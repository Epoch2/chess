class PawnMovement extends FourWayPieceMovement {
    @Override
    public Path getPath(Position origin, Position target) {
        if (!canReachTarget(origin, target)) {
            return null;
        }

        return super.getPath(origin, target);
    }

    private boolean canReachTarget(Position origin, Position target) {
        Distance distance = origin.getDistanceTo(target);

        // Cannot move sideways
        if (distance.getY() == 0 && distance.getX() != 0) return false;

        // Cannot move more than one square
        if (distance.getX() + distance.getY() > 0) return false;

        return true;
    }
}
