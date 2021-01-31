package expression.exceptions;

public class ParsingException extends Exception {
    public ParsingException(final String message) {
        super(message);
    }
    public ParsingException(final String message, final int pos) {
        super("pos: " + pos + ", " + message);
    }
}
