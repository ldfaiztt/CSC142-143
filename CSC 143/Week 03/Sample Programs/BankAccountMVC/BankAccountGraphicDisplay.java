import javax.swing.*;
import java.awt.*;

/**
 * Sample listener for a really simple MVC example.
 * Most JavaDocs omitted.
 * @author CSC 143, VO
 * @version 1/20/04
 */
public class BankAccountGraphicDisplay extends JPanel implements BankAccountListener {
   
  private BankAccount account;
  
  public BankAccountGraphicDisplay( BankAccount acct ) {
    super( );
    this.setPreferredSize( new Dimension( 100, 300 ) );
    account = acct;
    account.addListener( this ); 
  }
  
  public void accountChanged() {
    this.repaint();
  }
  
  // override method inherited from JPanel to draw graphics
  public void paintComponent( Graphics g ) {
    // repaint background
    super.paintComponent( g );  

    // draw account balance bargraph
    Rectangle bounds = getBounds();
    int rectHeight = (int)Math.round( account.getBalance( ) ) * bounds.height / 20000;
    int rectWidth = bounds.width / 3;
    int rectX = rectWidth;
    int rectY = bounds.height - rectHeight;
    g.setColor( Color.GREEN.darker( ) );
    g.fillRect( rectX, rectY, rectWidth, rectHeight );
    
    // added 5/5/06
    final int MAX_BAL_DISP = 20000;
    int x = bounds.width*3/4;
    g.setColor( Color.BLACK );
    for ( int bal = 0; bal < MAX_BAL_DISP; bal += MAX_BAL_DISP/10 ) {
      g.drawString( "" + bal, 0, bounds.height - ( bounds.height * bal / MAX_BAL_DISP ) );
    }
  }
}