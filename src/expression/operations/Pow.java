package expression.operations;

import expression.AbstractBinaryOperation;
import expression.CommonExpression;
import expression.EnumBinaryOperation;
import expression.exceptions.OverflowException;

import static expression.DoubleOperations.pow;

public class Pow extends AbstractBinaryOperation {
    public Pow(CommonExpression left, CommonExpression right) {
        super(left, right, EnumBinaryOperation.Pow);
    }

    @Override
    public double doubleCalculate(double x, double y) throws OverflowException, ArithmeticException {
        return pow(x, y);
    }

    @Override
    public int getPriority() {
        return 3;
    }
}
