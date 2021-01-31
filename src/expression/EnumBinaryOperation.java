package expression;

import java.util.List;
import java.util.Map;
import java.util.Set;

public enum EnumBinaryOperation {
    Add, Sub, Mult, Div, Mod, Pow, Log, Undefined;

   public static Map<EnumBinaryOperation, String> stringByOp = Map.of(
       Add,       "+",
       Sub,       "-",
       Mult,      "*",
       Div,       "/",
       Mod,       "%",
       Pow,       "^",
       Log,       "//",
       Undefined, ""
   );

    public static Map<String, EnumBinaryOperation> opByString = Map.of(
        "+",    Add,
        "-",    Sub,
        "*",    Mult,
        "/",    Div,
        "%",    Mod,
        "^",    Pow,
        "//",   Log,
        "",     Undefined
    );

    public static List<Set<EnumBinaryOperation>> levels = List.of(
            Set.of(EnumBinaryOperation.Add, EnumBinaryOperation.Sub),
            Set.of(EnumBinaryOperation.Mult, EnumBinaryOperation.Div, EnumBinaryOperation.Mod),
            Set.of(EnumBinaryOperation.Pow, EnumBinaryOperation.Log)
    );

    public static EnumBinaryOperation getOpByString(final String op) {
        return opByString.getOrDefault(op, Undefined);
    }

    public static String getStringByOp(final EnumBinaryOperation op) {
        return stringByOp.get(op);
    }
}
