import java.util.Scanner;
/**
 * An Interactive Espresso Stand.  Use this with your EspressoStand code.
 * 
 * @author CSC 142 
 * @version Fall 2011
 */
public class Espresso
{
    // constants
    private static final int QUIT = 4;
    private static final int ORDER = 1;
    private static final int INVENTORY = 2;
    private static final int SALES = 3;
    
    /**
     * Allows the program to be run as a stand-alone application.
     */
    public static void main( String[] args ) {
        Espresso s = new Espresso( );
        s.openStand( );
    }
    
    /**
     * Operate the espresso stand interactively with the user.
     */
    public static void openStand( ) {
        EspressoStand stand = new EspressoStand( );
        System.out.println( "The Espresso Stand is open for business!" );
        Scanner console = new Scanner( System.in );
        int choice;
        do { // main menu loop
            System.out.print( "\nOptions:\n  1: Place an order\n"
              + "  2: Show inventory\n  3: Show total sales\n  4: Quit\n" );
            System.out.print( "Enter the number for your choice: " );
            choice = console.nextInt( );
            System.out.println( );
            switch ( choice ) {
                case ORDER: 
                    takeOrder( console, stand );
                    break;
                case INVENTORY:
                    System.out.println( stand.getInventory( ) );
                    break;
                case SALES:
                    double sales = stand.getTotalSales( );
                    sales = Math.round( sales * 100.0 ) / 100.0;
                    System.out.println( "Total sales: $" + sales );
                    break;
                case QUIT: // do nothing
                    break;
                default:
                    System.out.println( "INVALID CHOICE -- please try again." );
            }
        } while ( choice != QUIT );
        
        System.out.println( "Thank you for visiting the Espresso Stand!" );
    }
    
    /**
     * A private method to get the information required to place an order.
     * This "proof of concept" method has no input validation. 
     * @param in a Scanner object linked to the source of input data (e.g. the console)
     * @param stand the EspressoStand object that will receive the orders
     */
    private static void takeOrder( Scanner in, EspressoStand stand ) {
        System.out.println( "Please enter your order:" );
        System.out.print( "How many single-short lattes? " );
        int ss = in.nextInt( );
        System.out.print( "How many double-short lattes? " );
        int ds = in.nextInt( );
        System.out.print( "How many double-tall lattes? " );
        int dt = in.nextInt( );
        System.out.print( "How many cookies? " );
        int c = in.nextInt( );
        Order o = new Order( ss, ds, dt, c );
        double cost = stand.processOrder( o );
        cost = Math.round( cost * 100.0 ) / 100.0;
        System.out.println( "Please pay $" + cost + " at the register." );
    }

}
