import java.util.*;
/**
 * Really simple model for a really simple MVC example.
 * Project BankAccountMVC2; most JavaDocs omitted.
 * @author CSC 143, VO; original 1/20/04; updated 1/22/07
 * @version 1/22/07
 */
public class BankAccount {
  
  private double balance; // balance in dollars
  private ArrayList<BankAccountListener> listeners;
  
  public BankAccount( double initBal ) {
    listeners = new ArrayList<BankAccountListener>();
    balance = 0;
    deposit( initBal );
  }
  
  // basic BankAccount operations
  
  public double getBalance() {
    return Math.round( ( balance * 100 ) ) / 100;
  }
  
  public void deposit( double amt ) {
    if ( amt > 0 ) {
      balance += amt;
      notifyAllListeners();
    }
  }
  
  public double withdrawal( double amt ) {
    if ( amt <= getBalance() ) {
      balance -= amt;
      notifyAllListeners();
      return amt;
    }
    return 0.0;
  }
  
  // operations to support listeners
  
  public void addListener( BankAccountListener c ) {
    if ( c != null ) {
      listeners.add( c );
      c.accountChanged(); // update new listener (may omit)
    }
  }
  
  private void notifyAllListeners() {
    Iterator<BankAccountListener> it = listeners.iterator();
    while ( it.hasNext() ) {
      BankAccountListener c = it.next();
      c.accountChanged();
    }
  }
}