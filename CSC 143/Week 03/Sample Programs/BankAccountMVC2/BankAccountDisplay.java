import javax.swing.*;
import java.awt.*;

/**
 * Sample listener for a really simple MVC example.
 * Project BankAccountMVC2; most JavaDocs omitted.
 * @author CSC 143, VO
 * @version 1/20/04
 */
public class BankAccountDisplay extends JPanel implements BankAccountListener {
   
  private BankAccount account;
  private JLabel balDisp;
  
  public BankAccountDisplay( BankAccount acct ) {
    super( );
    this.setPreferredSize( new Dimension( 100, 40 ) );
    balDisp = new JLabel( "$0" );
    this.add( balDisp );
    account = acct;
    account.addListener( this ); 
  }
  
  public void accountChanged() {
    balDisp.setText( "$" + account.getBalance( ) );
  }
}