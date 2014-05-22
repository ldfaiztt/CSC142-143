import java.util.*;

public class PrefixEvaluator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("This program evaluates prefix expressions");
        System.out.println("for operators +, -, *, / and %");
        System.out.print("expression? ");
        System.out.println("value = " + evaluate(console));
    }

    // pre : input contains a legal prefix expression
    // post: expression is consumed and the result is returned
    public static double evaluate(Scanner input) {
        if (input.hasNextDouble()) {
            return input.nextDouble();
        } else {
            String operator = input.next();
            double operand1 = evaluate(input);
            double operand2 = evaluate(input);
            return evaluate(operator, operand1, operand2);
        }
    }

    // pre : operator is one of +, -, *, / or %
    // post: returns the result of applying the given operator to
    //       the given operands
    public static double evaluate(String operator, double operand1,
                                  double operand2) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else if (operator.equals("/")) {
            return operand1 / operand2;
        } else if (operator.equals("%")) {
            return operand1 % operand2;
        } else {
            throw new RuntimeException("illegal operator " + operator);
        }
    }
}
