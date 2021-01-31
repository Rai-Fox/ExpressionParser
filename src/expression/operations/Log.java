package expression.operations;

import expression.AbstractBinaryOperation;
import expression.CommonExpression;
import expression.EnumBinaryOperation;
import expression.exceptions.ArithmeticException;

import static expression.DoubleOperations.log;

public class Log extends AbstractBinaryOperation {
    public Log(CommonExpression left, CommonExpression right) {
        super(left, right, EnumBinaryOperation.Log);
    }

    @Override
    public double doubleCalculate(double x, double y) throws ArithmeticException {
        return log(x, y);
    }

    @Override
    public int getPriority() {
        return 3;
    }
}
