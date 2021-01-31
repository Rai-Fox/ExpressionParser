package expression.exceptions;

public class IllegalOperatorException extends ParsingException {
    public IllegalOperatorException(final String op) {
        super("Illegal operation: " + op);
    }
    public IllegalOperatorException(final String op, final int pos) {
        super("Illegal operation: " + op, pos);
    }
}
