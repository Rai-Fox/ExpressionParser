package expression.operations;

import expression.CommonExpression;

import java.util.List;

public class Variable implements CommonExpression {
    private final String name;
    private final int num;
    public Variable(final String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int getPriority() {
        return 99;
    }

    @Override
    public double evaluate(double ...args) {
        return args[num];
    }

    @Override
    public List<String> getVariables() {
        return List.of(this.name);
    }

    @Override
    public boolean equals(Object b) {
        if (b == this) {
            return true;
        }
        if (b == null || b.getClass() != this.getClass()) {
            return false;
        }
        return name.equals(((Variable) b).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
