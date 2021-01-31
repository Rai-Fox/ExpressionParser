package expression.parser;

import expression.*;
import expression.exceptions.*;
import expression.operations.*;

import static expression.EnumBinaryOperation.*;

public class ExpressionParser extends BaseParser implements Parser {
    final static int MAX_LEVEL = levels.size() - 1;
    private EnumBinaryOperation operation = Undefined;

    public ExpressionParser(ExpressionSource source) {
        setSource(source);
    }

    public ExpressionParser() { }

    @Override
    public Expression parse(String expression) throws ParsingException {
        return parse(new StringSource(expression));
    }

    private CommonExpression parse(ExpressionSource source) throws ParsingException {
        setSource(source);
        CommonExpression result = parseExpression();
        if (ch != '\0') {
            throw new UnexpectedSymbolException("Expected: EOF, found: " + ch, pos);
        }
        return result;
    }

    private CommonExpression parseExpression() throws ParsingException {
        return parseLevel(0);
    }

    private CommonExpression nextLevel(int level) throws ParsingException {
        if (level == MAX_LEVEL) {
            return parseValue();
        } else {
            return parseLevel(level + 1);
        }
    }

    private boolean isThisLevelOp(int level) {
        operation = getOpByString("" + ch + secondCh);
        if (operation == Undefined) {
            operation = getOpByString("" + ch);
            return levels.get(level).contains(operation);
        }
        return levels.get(level).contains(operation);
    }

    private CommonExpression parseLevel(int level) throws ParsingException {
        skipWhitespace();
        CommonExpression result = nextLevel(level);
        skipWhitespace();
        while (isThisLevelOp(level)) {
            for (int i = 0; i < getStringByOp(operation).length(); i++)
                nextChar();
            result = createExpression(operation, result, nextLevel(level));
            skipWhitespace();
        }
        return result;
    }

    private CommonExpression parseValue() throws ParsingException {
        skipWhitespace();
        CommonExpression result;
        if (test('(')) {
            result = parseExpression();
            if (!test(')')) {
                throw new UnexpectedSymbolException("Excepted: ')', found: '" + ch + "'", pos);
            }
        } else if (test('-')) {
            if (between('0', '9')) {
                result = parseConst(true);
            } else {
                result = new Negate(parseValue());
            }
        } else if (between('0', '9')) {
            result = parseConst(false);
        } else if (test('%') || test(':') || test('_') || between('a', 'z') || between('A', 'Z')){
            result = parseVariable();
        } else {
            throw new MismatchArgumentException("Expected argument, found: " + ch, pos);
        }
        return result;
    }

    private CommonExpression parseUnary(final String op) throws ParsingException {
        expect(op);
        if (!check('-') && !check('(') && !testWhiteSpace()) {
            throw new UnexpectedSymbolException("Expected: '-', '(',  or ' ', found: " + ch, pos);
        }
        return parseValue();
    }

    private CommonExpression parseVariable() {
        StringBuilder name = new StringBuilder();
        while(check('%') || check(':') || check('_') || between('a', 'z') || between('A', 'Z')) {
            name.append(ch);
            nextChar();
        }
        return new Variable(name.toString(), nextVariableNum());
    }

    private CommonExpression parseConst(boolean isNegative) throws ParsingException {
        final StringBuilder sb = new StringBuilder();
        if (isNegative) {
            sb.append('-');
        }
        while(between('0', '9')) {
            sb.append(ch);
            nextChar();
        }
        if (test('.')) {
            sb.append('.');
        }
        while(between('0', '9')) {
            sb.append(ch);
            nextChar();
        }
        try {
            return new Const(Double.parseDouble(sb.toString()));
        } catch (NumberFormatException e) {
            throw new MismatchArgumentException("Constant overflow: " + sb, pos);
        }
    }

    private void skipWhitespace() {
        while (testWhiteSpace()) {
            // skip
        }
    }

    private CommonExpression createExpression(EnumBinaryOperation op,
                                              CommonExpression left,
                                              CommonExpression right) throws ParsingException {
        switch (op) {
            case Add:
                return new Add(left, right);
            case Sub:
                return new Subtract(left, right);
            case Mult:
                return new Multiply(left, right);
            case Div:
                return new Divide(left, right);
            case Pow:
                return new Pow(left, right);
            case Log:
                return new Log(left, right);
            case Mod:
                return new Mod(left, right);
        }
        throw new IllegalOperatorException(getStringByOp(op));
    }
}
