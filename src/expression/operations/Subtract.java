package expression.operations;

import expression.AbstractBinaryOperation;
import expression.CommonExpression;
import expression.EnumBinaryOperation;
import expression.exceptions.OverflowException;

import static expression.DoubleOperations.subtract;

public class Subtract extends AbstractBinaryOperation {
    public Subtract(CommonExpression left, CommonExpression right) {
        super(left, right, EnumBinaryOperation.Sub);
    }

    @Override
    public double doubleCalculate(double x, double y) throws OverflowException {
        return subtract(x, y);
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
