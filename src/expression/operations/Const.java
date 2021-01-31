package expression.operations;

import expression.CommonExpression;

import java.util.ArrayList;
import java.util.List;

public class Const implements CommonExpression {
    private final Number num;

    public Const(final double num) {
        this.num = num;
    }
    public Const(final int num) {
        this.num = num;
    }
    @Override
    public double evaluate(double ...args) {
        return num.doubleValue();
    }

    @Override
    public List<String> getVariables() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return num.toString();
    }

    @Override
    public int getPriority() {
        return 99;
    }

    @Override
    public boolean equals(Object b) {
        if (b == this) {
            return true;
        }
        if (b == null || b.getClass() != this.getClass()) {
            return false;
        }
        return num.equals(((Const) b).num);
    }

    @Override
    public int hashCode() {
        return (num.intValue() << 16) * 31;
    }

}
