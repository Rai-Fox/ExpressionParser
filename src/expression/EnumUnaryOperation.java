package expression;

import java.util.Map;

public enum EnumUnaryOperation {
    UnMinus, Undefined;

    public static Map<EnumUnaryOperation, String> stringByOp = Map.of(
            UnMinus,   "-",
            Undefined, ""
    );

    public static Map<String, EnumUnaryOperation> opByString = Map.of(
            "-",     UnMinus,
            "",      Undefined
    );

    public static EnumUnaryOperation getOpByString(final String op) {
        return opByString.getOrDefault(op, Undefined);
    }

    public static String getStringByOp(final EnumUnaryOperation op) {
        return stringByOp.get(op);
    }
}
