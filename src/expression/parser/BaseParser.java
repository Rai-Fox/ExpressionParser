package expression.parser;

import expression.exceptions.ParsingException;
import expression.exceptions.UnexpectedSymbolException;

public class BaseParser {
    private ExpressionSource source;
    protected char ch;
    protected char secondCh;
    protected int pos = 0;
    protected BaseParser() {
    }

    protected BaseParser(final ExpressionSource source) {
        setSource(source);
    }

    public int nextVariableNum() {
        return source.nextVariableNum();
    }

    protected void setSource(final ExpressionSource source) {
        this.source = source;
        pos = 0;
        nextChar();
        nextChar();
    }

    protected boolean hasNext() {
        return source.hasNext();
    }

    protected void nextChar() {
        ch = secondCh;
        if (hasNext()) {
            secondCh = source.next();
            pos++;
        } else {
            secondCh = '\0';
        }
    }

    protected boolean test(char expected) {
        if (ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }

    protected boolean test(final String value) {
        for (char c : value.toCharArray()) {
            if (!test(c)) {
                return false;
            }
        }
        return true;
    }

    protected boolean testWhiteSpace() {
        if (isWhitespace(ch)) {
            nextChar();
            return true;
        }
        return false;
    }

    protected boolean check(char expected) {
        if (ch == expected) {
            return true;
        }
        return false;
    }

    protected void expect(final char c) throws ParsingException {
        if (ch != c) {
            throw new UnexpectedSymbolException("Expected: '" + c + "', found: '" + ch + "'", pos);
        }
        nextChar();
    }

    protected void expect(final String value) throws ParsingException {
        for (char c : value.toCharArray()) {
            expect(c);
        }
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }

    protected boolean isWhitespace(char c) {
        return c == ' ' || c == '\n' || c == '\t' || c == '\r';
    }
}
