import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Sample controller for a really simple MVC example.
 * In this version of the simulation, each bank account is assigned
 * an individual account 'manager' (a controller) that implements
 * customized rules for the management of the account.  This idea 
 * could  be extended by extending the BankAccountManager class
 * and providing even more specialization.
 * Project BankAccountMVC2; most JavaDocs omitted.
 * @author CSC 143, VO; original 1/20/04; updated 1/22/07
 * @version 1/22/07
 */
public class BankAccountMVC2 implements ActionListener {
  
  private static final int delay = 100; // timer delay in ms
  private static final double initDeposit = 2000.0; // initial deposit for all accts
  private static final int[] spending = { 0, 100, 400 }; // weekly spending by acct
  private int day = 0;
  private ArrayList<BankAccountManager> accountManagers;
  
  // To support 'F2' in DrJava
  public static void main( String[] args ) { 
    new BankAccountMVC2();
  }
    
  // setup and control simulation 
  
  public BankAccountMVC2 () {
    
    // create accounts and account managers
    accountManagers = new ArrayList<BankAccountManager>( );
    JPanel acctPanel = new JPanel( );
    for ( int i = 0; i < spending.length; i++ ) {
      BankAccount a = new BankAccount( initDeposit );  // local variable
      BankAccountManager m = new BankAccountManager( a );
      m.setWeeklySpending( spending[i] );
      accountManagers.add( m );
      JPanel subpanel = new JPanel( );
      subpanel.setPreferredSize( new Dimension( 100, 400 ) );
      subpanel.add( new BankAccountDisplay( a ) );
      subpanel.add( new BankAccountGraphicDisplay( a ) );
      acctPanel.add( subpanel );
    }
    
    // create & show GUI 1
    JFrame win = new JFrame( "Bank Account Viewer" );
    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    win.getContentPane().add( acctPanel );
    win.pack();
    win.setVisible( true ); 
    
    javax.swing.Timer clock = new javax.swing.Timer( delay, this );
    clock.start( );
  }
  
  // required to implement ActionListener
  /**
   * Action to be performed on each clock tick:
   * Instruct each account manager to simulate one day passing.
   */
  public void actionPerformed( ActionEvent evt ) {
    // one day passes
    day = ( day + 1 ) % 30; // oversimplified calendar: days 0 .. 29
    Iterator<BankAccountManager> it = accountManagers.iterator( );
    while( it.hasNext( ) ) {
      BankAccountManager m = it.next( );
      m.processOneDay( day );
    }
  }
  
}