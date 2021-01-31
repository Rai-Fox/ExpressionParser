package expression.parser;

import expression.Expression;
import expression.exceptions.ParsingException;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface Parser {
    Expression parse(String expression) throws ParsingException;
}
