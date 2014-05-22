import javax.swing.*;
/**
 * Simple button demonstration as shown in the PowerPoint slides.
 * Original from CSE 143, Sp03.
 * 
 * @author Hal Perkins
 * @version 4/17/03; mod 1/22/05, vo 
 */
public class ButtonDemo extends JPanel {
  
  /**
   * Construct a new ButtonDemo (IS-A JPanel): 
   * 1. Create a new JButton and set its action command.
   * 2. Create a new ButtonListener and register it with the JButton.
   * 3. Add the button to the panel.
   */
  public ButtonDemo( ) {
    JButton button = new JButton( "Hit me!" );
    button.setActionCommand( "OUCH!" );     // optional - default is button text
    button.addActionListener( new ButtonListener( ) );
    add( button );
  }
  
}