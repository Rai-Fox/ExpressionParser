package expression.operations;

import expression.AbstractBinaryOperation;
import expression.CommonExpression;
import expression.EnumBinaryOperation;
import expression.exceptions.OverflowException;

import static expression.DoubleOperations.mod;

public class Mod extends AbstractBinaryOperation {
    public Mod(CommonExpression left, CommonExpression right) {
        super(left, right, EnumBinaryOperation.Mod);
    }

    @Override
    public double doubleCalculate(double x, double y) throws OverflowException {
        return mod(x,y);
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
