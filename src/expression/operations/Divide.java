package expression.operations;

import expression.AbstractBinaryOperation;
import expression.CommonExpression;
import expression.EnumBinaryOperation;
import expression.exceptions.DivideByZeroException;
import expression.exceptions.OverflowException;

import static expression.DoubleOperations.divide;

public class Divide extends AbstractBinaryOperation {

    public Divide(CommonExpression left, CommonExpression right) {
        super(left, right, EnumBinaryOperation.Div);
    }

    @Override
    public double doubleCalculate(double x, double y) throws OverflowException, DivideByZeroException {
        return divide(x,y);
    }

    @Override
    public int getPriority() {
        return 2;
    }

}
