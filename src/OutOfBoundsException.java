/**
 * Created by jv on 22/09/16.
 */
public class OutOfBoundsException extends GameplayException {
    public OutOfBoundsException(Position position) {
        super("Out of bounds: " + position);
    }
}
