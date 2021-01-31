package expression.operations;

import expression.AbstractBinaryOperation;
import expression.CommonExpression;
import expression.EnumBinaryOperation;
import expression.exceptions.OverflowException;

import static expression.DoubleOperations.multiply;

public class Multiply extends AbstractBinaryOperation {
    public Multiply(CommonExpression left, CommonExpression right) {
        super(left, right, EnumBinaryOperation.Mult);
    }

    @Override
    public double doubleCalculate(double x, double y) throws OverflowException {
        return multiply(x,y);
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
