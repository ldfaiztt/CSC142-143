import java.util.Scanner;
/**
 * Several examples of simulation loops.
 * 
 * Java version 1.5.0 or higher is required to use the Scanner class.
 * 
 * @author csc 142 
 * @version 2-5-06
 */
public class SimulationLoops
{
    /**
     * Asks the user to enter 5 numbers, and then reports the average.
     */
    public static void averageFive( ) {
        Scanner in = new Scanner( System.in );
        final int maxCount = 5;
        int count;
        double sum = 0; // INITIALIZE ACCUMULATOR
        for ( count = 0; count < maxCount; count++ ) {
            System.out.print( "Enter a number: " );
            double num = in.nextDouble( );
            sum += num;
        }
        double ave = sum / maxCount; 
        System.out.println( "Average = " + ave );
    }
    
    /**
     * Determines the balance remaining due on a credit card account
     * after a specified number of months have passed with interest 
     * charged and payments made as specified.
     * 
     * @param initialBalance the initial account balance in dollars
     * @param annualPercentageRate annual interest rate as a percentage
     * @param monthlyPayment monthly payment made in dollars
     * @param numberOfMonths number of months to simulate
     * @return the account balance at the end of the simulation, in dollars
     */
    public static double creditCardSim( 
                         double initialBalance, double annualPercentageRate, 
                         double monthlyPayment, int numberOfMonths ) 
    {
        double monthlyMultiplier = annualPercentageRate / 1200;
        double balance = initialBalance;
        for( int month = 1; month <= numberOfMonths; month++ ) {
            balance = balance + balance * monthlyMultiplier;
            balance = balance - monthlyPayment;
        }
        if ( balance < 0 )
            balance = 0;  // final balance cannot be less than 0
        return balance;
    }
    
    /**
     * Determines the number of months required to pay off a credit card 
     * account with interest charged and payments made as specified.
     * 
     * Note: Maximum number of months returned is 1200.  If the number 
     * returned is less than 1200, the account was successfully paid off.
     * If the number of months is equal to 1200, the account may not have
     * been paid off (balance may be increasing because monthly payment 
     * is too low).
     * 
     * @param initialBalance the initial account balance in dollars
     * @param annualPercentageRate annual interest rate as a percentage
     * @param monthlyPayment monthly payment made in dollars
     * @return the number of months required to pay off the account
     */
    public static double monthsToPayOffBalance( 
                         double initialBalance, double annualPercentageRate, 
                         double monthlyPayment ) 
    {
        double monthlyMultiplier = annualPercentageRate / 1200;
        double balance = initialBalance;
        int month = 0;
        do {
            balance = balance + balance * monthlyMultiplier;
            balance = balance - monthlyPayment;
            month++;
        } while ( balance > 0 && month < 1200 );
        return month;
    }
    
    /**
     * This example illustrates a DATA VALIDATION loop and also a loop-based
     * process SIMULATION.  This simulation uses several different accumulators.
     */
    public static void flyingBall( ) {
        Scanner in = new Scanner( System.in );
        System.out.println( "This program will analyze the flight of a baseball." );
        System.out.println( "The ball is thrown by a player with specified \n"
                            + "horizontal and vertical velocity components.\n"
                            + "The program calculates\n 1) how long it will take "
                            + "for the ball to hit the ground and \n 2) how far "
                            + "it travels from its starting point." );
        System.out.println( "The ball's flight begins when it leaves the player's hand" 
                            + "\n6 feet above the ground and ends when it hits the ground." );
        System.out.print( "\nEnter vx0, the x-component of starting velocity "
                          + "in ft/sec. ( >=0 ): " );
        double vx0 = in.nextDouble( ); 
        while ( vx0 < 0 ) { // input validation
            System.out.print( "TRY AGAIN: vx0 must be >=0 : " );
            vx0 = in.nextDouble( ); 
        }
        System.out.print( "\nEnter vy0, the y-component of starting velocity "
                          + "in ft/sec.: " );
        double vy0 = in.nextDouble( ); 
        
        // ASSUMPTIONS
        // Acceleration of gravity is approximated at 32 feet per second squared
        // Friction and other secondary effects are ignored.
        
        // INITIALIZATIONS
        final double a = 32; // ft/sec/sec
        final double dt = 0.1; // 0.01 seconds per simulation step
        double x0 = 0; // feet
        double y0 = 6; // feet -- ball starts 6 feet above the ground
        double vx = vx0; // this velocity component never changes
        double t = 0; // time in seconds
        double y = y0;
        double x = x0;
        double vy;
        while ( y > 0 ) {
            t += dt;
            x = x0 + vx0 * t;
            y = y0 + vy0 * t - a * t * t / 2.0;
            vy = vy0 - a * t;
              //trace statements
              String format = "Time = %4.1f, x =%7.3f, y =%7.3f, vx =%7.3f, vy =%7.3f \n";
              System.out.printf( format, t, x, y, vx, vy );
        }
        t = Math.round( t * 10 ) / 10.0;
        int x2 = (int)Math.round( x );
        System.out.println( "\nAfter " + t + " seconds, the ball hits the "
                            + "ground " + x2 + " feet away." );
        // tested with vx0=40 and vy0=30; result:
        // "After 2.1 seconds, the ball hits the ground 84 feet away."

    }
    
}
