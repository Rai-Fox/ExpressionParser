package expression.parser;

public class StringSource implements ExpressionSource {
    final String data;
    private int pos;
    private int variableNum = 0;
    public StringSource(final String data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return pos < data.length();
    }

    @Override
    public char next() {
        return data.charAt(pos++);
    }

    @Override
    public ExpressionException error(final String message) {
        return new ExpressionException(pos + ": " + message);
    }

    @Override
    public int getPos() {
        return pos;
    }

    public int nextVariableNum() {
        return variableNum++;
    }
}