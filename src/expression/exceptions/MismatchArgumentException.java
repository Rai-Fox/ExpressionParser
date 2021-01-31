package expression.exceptions;

public class MismatchArgumentException extends ParsingException {
    public MismatchArgumentException(final String message) {
        super(message);
    }
    public MismatchArgumentException(final String message, final int pos) {
        super(message, pos);
    }
}