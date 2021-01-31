import expression.Expression;
import expression.exceptions.ParsingException;
import expression.parser.ExpressionParser;

public class Main {
    public static void main(String[] args) throws ParsingException {
        ExpressionParser parser = new ExpressionParser();
        Expression expr;
        expr = parser.parse("((x)) ^ 2 + 5.6 % 2 + 5");
        System.out.println(expr.evaluate(5));
        System.out.println(expr.getVariables());
        System.out.println(expr.toString());
        System.out.println(expr.toMiniString());
        expr = parser.parse("owner:PLAYER_DAMAGE * (1 - 0.00667 * target:PLAYER_DEFENSE / (1 +  0.00667 * target:PLAYER_DEFENSE))");
        for (int def = 10; def < 100; def += 10) {
            for (int dmg = 10; dmg < 100; dmg += 10) {
                System.out.print(Double.toString(expr.evaluate(dmg, def, def)).substring(0, 4));
                System.out.print("   ");
            }
            System.out.println();
        }
        System.out.println(expr.getVariables());
    }
}
