package expression;

import expression.exceptions.DivideByZeroException;
import expression.exceptions.OverflowException;
import expression.exceptions.ParsingException;
import expression.operations.Variable;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryOperation implements CommonExpression {
    EnumBinaryOperation op;
    private final CommonExpression left, right;
    private final List<String> variables;
    public AbstractBinaryOperation(final CommonExpression left, final CommonExpression right, final EnumBinaryOperation op) {
        this.left = left;
        this.right = right;
        this.op = op;
        this.variables = new ArrayList<>();
        variables.addAll(left.getVariables());
        variables.addAll(right.getVariables());
    }

    public List<String> getVariables() {
        return List.copyOf(this.variables);
    }

    public abstract double doubleCalculate(double x, double y) throws ArithmeticException;

    public String getOperation() {
        return EnumBinaryOperation.getStringByOp(op);
    }

    public abstract int getPriority();

    public boolean isAssocOperation() {
        return op == EnumBinaryOperation.Add || op == EnumBinaryOperation.Mult;
    };

    @Override
    public String toString() {
        //return toMiniString();
        return "(" + left.toString() + getOperation() + right.toString() + ")";
    }

    private boolean checkRight() {
        return right instanceof AbstractBinaryOperation
            && getPriority() == right.getPriority()
            && (!isAssocOperation() || !((AbstractBinaryOperation) right).isAssocOperation());
    }

    private static String getBrackets(final String s, final boolean isBrackets) {
        if (isBrackets) {
           return "(" + s + ")";
        } else {
            return s;
        }
    }

    @Override
    public String toMiniString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getBrackets(left.toMiniString(), getPriority() > left.getPriority()));
        sb.append(getOperation());
        sb.append(getBrackets(right.toMiniString(), getPriority() > right.getPriority() || checkRight()));
        return sb.toString();
    }

    @Override
    public double evaluate(double ...args) throws OverflowException, DivideByZeroException, ParsingException {
        return doubleCalculate(left.evaluate(args), right.evaluate(args));
    }

    @Override
    public boolean equals(Object b) {
        if (b == this) {
            return true;
        }
        if (b == null || b.getClass() != this.getClass()) {
            return false;
        }
        return left.equals(((AbstractBinaryOperation) b).left)
           &&  right.equals(((AbstractBinaryOperation) b).right)
           &&  op == ((AbstractBinaryOperation) b).op;
    }

    @Override
    public int hashCode() {
        return left.hashCode() + 31 * (right.hashCode() +  31 * getOperation().hashCode());
    }
}
