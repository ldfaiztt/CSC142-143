// variation that prints in postfix

// This program prompts for fully-parenthesized arithmetic
// expressions and it evalues each expression.  It uses two
// stacks to evaluate the expressions.

import java.util.*;

public class Evaluator2 {
    public static void main(String[] args) {
        System.out.println("This program evaluates fully");
        System.out.println("parenthesized expressions with the");
        System.out.println("operators +, -, *, +, and ^");
        System.out.println();
        Scanner console = new Scanner(System.in);
        System.out.print("expression (return to quit)? ");
        String line = console.nextLine().trim();
        while (line.length() > 0) {
            System.out.println("postfix version: " + postfix((line)));
            System.out.print("expression (return to quit)? ");
            line = console.nextLine().trim();
        }
    }

    // pre : line contains a fully parenthesized expression
    // post: prints the value of the expression or an error
    //        message if the expression is not legal
   public static String postfix(String line) {
        StringSplitter data = new StringSplitter(line);
        Stack<String> symbols = new Stack<String>();
        String result = "";
        boolean error = false;
        while (!error && data.hasNext()) {
            String next = data.next();
            if (next.equals(")")) {
                if (symbols.size() < 2 || symbols.peek().equals("(")) {
                    error = true;
                } else {
                    String operator = symbols.pop();
                    if (!symbols.peek().equals("(")) {
                        error = true;
                    } else {
                        symbols.pop(); // to remove the "("
                        // CHANGE: pop and append  when you see a right-paren
                        result = result + " " + operator;
                    }
                }
            } else if ("(+-*/^".indexOf(next) != -1) {
                symbols.push(next);
            } else {  // it should be a number
                // CHANGE: append nums when you see them
                result = result + " " + Double.parseDouble(next);
            }
        }
        if (error || !symbols.isEmpty()) {
            return "illegal expression";
        } else {
            return result;
        }
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