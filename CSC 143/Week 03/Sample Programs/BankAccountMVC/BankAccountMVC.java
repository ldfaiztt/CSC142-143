import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Sample controller for a really simple MVC example.
 * Most JavaDocs omitted.
 * @author CSC 143, VO
 * @version 1/20/04
 */
public class BankAccountMVC implements ActionListener {
  
  private int delay = 100; // timer delay in ms
  private int day = 0;
  private BankAccount account;
  
  // To support 'F2' in DrJava
  public static void main( String[] args ) { 
    new BankAccountMVC();
  }
    
  // setup and control simulation 
  
  public BankAccountMVC () {
    account = new BankAccount( 2000 ); // create account
    
    // create & show GUI 1
    JFrame win = new JFrame( "Bank Account Viewer" );
    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    BankAccountDisplay disp = new BankAccountDisplay( account ); // IS-A JPanel
    win.getContentPane().add( disp );
    BankAccountGraphicDisplay disp2 = new BankAccountGraphicDisplay( account ); // IS-A JPanel
    win.getContentPane().add( disp2, BorderLayout.EAST );
    win.pack();
    win.setVisible( true ); 
    
    Timer clock = new Timer( delay, this );
    clock.start( );
  }
  
  // required to implement ActionListener
  
  public void actionPerformed(ActionEvent evt) {
    // one day passes
    day = ( day + 1 ) % 30; // oversimplified calendar: days 0 .. 29
    
    if ( day == 10 || day == 25 )
      account.deposit( 1000 ); // deposit paycheck
    if ( day == 29 ) 
      account.withdrawal( 1200 ); // pay rent
    if ( day % 7 == 0 ) 
      account.withdrawal( 100 ); // buy food, etc.
  }
  
}