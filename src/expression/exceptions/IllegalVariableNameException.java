package expression.exceptions;

public class IllegalVariableNameException extends ParsingException {
    public IllegalVariableNameException(final String name) {
        super("Invalid variable name: " + name);
    }
    public IllegalVariableNameException(final String name, final int pos) {
        super("Invalid variable name: " + name, pos);
    }
}
