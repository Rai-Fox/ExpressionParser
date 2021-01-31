package expression.operations;

import expression.AbstractUnaryOperation;
import expression.CommonExpression;
import expression.EnumUnaryOperation;
import expression.exceptions.OverflowException;

import static expression.DoubleOperations.negate;

public class Negate extends AbstractUnaryOperation {
    public Negate(CommonExpression expr) {
        super(expr, EnumUnaryOperation.UnMinus);
    }

    @Override
    public double doubleCalculate(double x) throws OverflowException {
        return negate(x);
    }

    @Override
    public int getPriority() {
        return 4;
    }
}
