// This program prompts for information about a loan and
// computes the monthly loan payment.

import java.util.*;   // for Scanner

public class Mortgage {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // obtain values
        System.out.println("This program computes monthly " +
                           "loan payments.");
        System.out.print("loan amount     : ");
        double loan = console.nextDouble();
        System.out.print("number of years : ");
        int years = console.nextInt();
        System.out.print("interest rate   : ");
        double rate = console.nextDouble();
        System.out.println();

        // compute result and report
        int n = 12 * years;
        double c = rate / 12.0 / 100.0;
        double payment = loan * c * Math.pow(1 + c, n) /
                         (Math.pow(1 + c, n) - 1);
        System.out.println("payment = $" + (int) payment);
    }
}
