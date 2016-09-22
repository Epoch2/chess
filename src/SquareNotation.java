/**
 * Created by jv on 22/09/16.
 */
public class SquareNotation {
    private String rank;
    private String file;

    public SquareNotation(String rank, String file) {
        this.rank = rank;
        this.file = file;
    }

    public SquareNotation(String denotation) {
        if (denotation.length() % 2 != 0) {
            throw new IllegalArgumentException("Cannot parse square denotation: " + denotation);
        }

        int middle = denotation.length()/2;

        this.rank = denotation.substring(0, middle);
        this.file = denotation.substring(middle);
    }

    public String getFile() {
        return file;
    }

    public String getRank() {
        return rank;
    }
}
