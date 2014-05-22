/**
 * This is a class comment. Say something about the class.
 * Provides useful methods realted to mortgage calculations.
 * Include the following:
 * @author CSC 143
 * @version April 13, 2009
 */
public class Mortgage {
  
  /**
   * Calculates the monthly payment on a fixed-rate mortgage.
   * Interest is compounded monthly.
   * @param principal the amount of money borrowed in dollars
   * @param annualPercentageRate the annual interest rate
   * @param termInYears the length of the mortgage
   * @return the monthly payment in dollars
   */
  public static double monthlyPayment( double principal, 
                                       double annualPercentageRate,
                                       int termInYears ) {
    double mm = annualPercentageRate / 1200; // monthly multiplier
    int periods = termInYears * 12;
    double payment = principal * mm / ( 1 - Math.pow( 1 + mm, -periods ) );
    return payment;
  }
  
  /**
   * Simple program-driven interaction.
   * TO DO: output formatting, validation and exception handling
   */
  public static void runInteractice( ) {
    java.util.Scanner in = new java.util.Scanner( System.in );
    System.out.println( "Computing monthly payment for a mortgage "
                        + "with a fixed rate.\n" );
    System.out.print( "Enter the principle amount: " );
    double principal = in.nextDouble( );
    System.out.print( "Enter the annual percentage interest rate: " );
    double rate = in.nextDouble( );
    System.out.print( "Enter the term of the mortgage in years: " );
    int term = in.nextInt( );
    double pmt = monthlyPayment( principal, rate, term );
    System.out.println( "A " + term + " year mortgage at " + rate + "% requires"
                          + " a monthly payment of $" + pmt );
    in.close( ); // Close the Scanner
  }
  
  /**
   * Application method for the Mortgage class.
   * Allows calculation of the payment on a fixed-rate mortgage.
   * TO DO: output formatting, validation and exception handling
   */
  public static void main( String[] args ) {
    if ( args.length == 0 )
      runInteractice( );
    else if ( args.length != 2 && args.length != 3 )
      System.out.println( "Usage: java Mortgage principalAmount annualPercentageRate\n"
                          + "    or java Mortgage principalAmount annualPercentageRate termInYears" );
    else {
      int term;
      if ( args.length == 3 )
        term = Integer.parseInt( args[2] );
      else
        term = 30; // default is 30 years
      double principal = Double.parseDouble( args[0] );
      double rate = Double.parseDouble( args[1] );
      double pmt = monthlyPayment( principal, rate, term );
      System.out.println( "A " + term + " year mortgage at " + rate + "% requires"
                          + " a monthly payment of $" + pmt );
    }
  }
  
}