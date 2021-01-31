package expression;

import expression.exceptions.DivideByZeroException;
import expression.exceptions.OverflowException;
import expression.exceptions.ParsingException;

import java.util.List;

public interface Expression extends ToMiniString {
    public double evaluate(double ...args) throws OverflowException, DivideByZeroException, ParsingException;
    public List<String> getVariables();
}
