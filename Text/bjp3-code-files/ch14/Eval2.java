import java.util.*;

public class Eval {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("expression? ");
        String line = console.nextLine();
        while (line.length() > 0) {
            evaluate(line);
            System.out.print("expression? ");
            line = console.nextLine();
        }
    }

    public static void evaluate(String line) {
        StringSplitter data = new StringSplitter(line);
        Stack<String> operators = new Stack<String>();
        Stack<Double> values = new Stack<Double>();
        while (data.hasNext()) {
            String next = data.next();
            if (next.equals(")")) {
                double value = evaluate(operators.pop(), values.pop(), values.pop());
                values.push(value);
            } else if ("+-*/^".indexOf(next) != -1) {
                operators.push(next);
            } else if (!next.equals("(")) {
                values.push(Double.parseDouble(next));
            }
        }
        System.out.println(values.pop());
    }

    // pre : operator is one of +, -, *, or /
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
        } else if (operator.equals("^")) {
            return Math.pow(operand1, operand2);
        } else {
            throw new RuntimeException("illegal operator " + operator);
        }
    }
}