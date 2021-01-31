package expression;

import expression.exceptions.ArithmeticException;
import expression.exceptions.DivideByZeroException;
import expression.exceptions.OverflowException;

public abstract class DoubleOperations {
    public static double negate(double x) {
        return -x;
    }

    public static double abs(double x) {
        return Math.abs(x);
    }

    public static double add(double x, double y) {
        return x + y;
    }

    public static double subtract(double x, double y) {
        return x - y;
    }

    public static double multiply(double x, double y) {
        return x * y;
    }

    public static double divide(double x, double y) {
        return x / y;
    }

    public static double mod(double x, double y) {
        return x % y;
    }
    public static double pow(double x, double y) {
        return Math.pow(x, y);
    }

    public static double log(double x, double y) {
        return Math.log(y) / Math.log(x);
    }

}
