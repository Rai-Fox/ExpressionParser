package expression.exceptions;

public class UnexpectedSymbolException extends ParsingException {
    public UnexpectedSymbolException(final String message) {
        super(message);
    }
    public UnexpectedSymbolException(final String message, final int pos) {
        super(message, pos);
    }
}
