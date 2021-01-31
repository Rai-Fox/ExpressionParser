package expression.operations;

import expression.AbstractBinaryOperation;
import expression.CommonExpression;
import expression.EnumBinaryOperation;
import expression.exceptions.OverflowException;

import static expression.DoubleOperations.add;

public class Add extends AbstractBinaryOperation {
    public Add(CommonExpression left, CommonExpression right) {
        super(left, right, EnumBinaryOperation.Add);
    }

    @Override
    public double doubleCalculate(double x, double y) throws OverflowException {
        return add(x, y);
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
