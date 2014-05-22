
/* 
 * 142 STUDENTS
 * You are not expected to understand most of the code in this class. 
 * You are welcome to look it over and ask me questions via email, but 
 * we will not spend class time going over this material. 
 * 
 * Want to learn how to create a Java GUI?  Come take CSC143!
 */

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

/** 
 * User Interface for the Espresso Stand project.
 * Allows customers to select combos
 * Displays current inventory and total $ receipts
 * 
 * @author CSC 142
 * @version Fall 2010
 */
public class EspressoStandApp implements ActionListener{
  private JSpinner combo1ct, combo2ct;
  private JLabel orderPrice, sales;
  private NumberFormat currencyFormatter;
  
  private String ORDER = "order";  // action commands for the 3 buttons
  private String INV = "inv";
  
  private EspressoStand cart;
  
  /**
   * Sets up the user interface (UI)
   */
  public EspressoStandApp(){
    // construct an object used to format the $ amounts
    currencyFormatter = NumberFormat.getCurrencyInstance();
    // construct the EspressoStand object that this UI serves
    cart = new EspressoStand();      
      
    // build up a heading for the top region in the window
    JLabel heading = new JLabel("WELCOME TO THE ESPRESSO STAND!!!");
    Font f = heading.getFont();
    heading.setFont( new Font( f.getName(), f.getStyle(), f.getSize() + 10) );
    heading.setIcon(new ImageIcon("Espresso.gif"));
    heading.setOpaque(true);
    heading.setBackground(new Color(191, 239,255));
    heading.setHorizontalAlignment(SwingConstants.CENTER);
    heading.setForeground(new Color(65, 105, 225));
    heading.setBorder(BorderFactory.createRaisedBevelBorder());
  
    // set up tools that allow the user to specify the order contents
    combo1ct = new JSpinner(new SpinnerNumberModel(0,0,10,1));
    combo2ct = new JSpinner(new SpinnerNumberModel(1,0, 15, 1));
    JPanel panelA = new JPanel();
    panelA.add(new JLabel("Number of combo 1 orders"));
    panelA.add(combo1ct);
    JPanel panelB = new JPanel();
    panelB.add(new JLabel("Number of combo 2 orders"));
    panelB.add(combo2ct);
    
    // set up the order button
    JButton order = new JButton("Place order");
    order.setForeground(Color.blue);
    order.addActionListener(this);
    order.setActionCommand(ORDER);
    JPanel panelC = new JPanel();
    panelC.add(order);
    
    // put the spinners, labels, and order button together in one panel
    JPanel panelD = new JPanel();
    panelD.setLayout(new BoxLayout(panelD, BoxLayout.Y_AXIS));
    panelD.add(panelA);
    panelD.add(panelB);
    panelD.add(panelC);
    
    // create labels to show results
    sales = new JLabel("Total Sales $0.00");
    sales.setOpaque(true);
    sales.setBackground(new Color(191, 239,255));
    orderPrice = new JLabel("Order price $0.00");
    orderPrice.setOpaque(true);
    orderPrice.setBackground(new Color(191, 239,255));
    
    // set up the inventory button
    JButton inventory = new JButton ("List Current Inventory");
    inventory.addActionListener(this);
    inventory.setActionCommand(INV);
    
    // put the results display and inventory button together in a panel
    JPanel mgrPanel = new JPanel();
    mgrPanel.setOpaque(true);
    mgrPanel.setBackground(new Color(155, 2, 155));
    mgrPanel.add(orderPrice);
    mgrPanel.add(inventory);
    mgrPanel.add(sales);
    mgrPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    
    // now set up the window itself
    JFrame win = new JFrame("Espresso Stand!");
    win.setSize(new Dimension(600, 300));
    win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    win.setBackground(new Color(152, 251, 152));

    // add the panels to the window
    win.getContentPane().add(heading, BorderLayout.NORTH);
    win.getContentPane().add(panelD, BorderLayout.CENTER);
    win.getContentPane().add(mgrPanel, BorderLayout.SOUTH);
    
    win.validate();
    win.setVisible(true);
  }
  
  /**
   * Defines what happens when a button is clicked.
   * @param e ActionEvent object contains info about which button was clicked
   */
  public void actionPerformed(ActionEvent e){
    String s = ((JButton) e.getSource()).getActionCommand();
    if (s.equals(ORDER) ) {
      // get order data from the UI
      int oneCount = ((Integer) combo1ct.getValue()).intValue();
      int twoCount = ((Integer) combo2ct.getValue()).intValue(); 
      // process the order
      double cost = cart.processOrder(new Order(oneCount,twoCount));
      // update the UI to show the effect of this order
      orderPrice.setText("Order price " + currencyFormatter.format(cost));
      sales.setText("Total Sales " + currencyFormatter.format(cart.getTotalSales()));
     }
     else if (s.equals(INV)) {
       // show the inventory in a dialog box
       String out = cart.getInventory();
       JOptionPane.showMessageDialog(null, out);
     }
  }
  
  /**
   * Launch the application.
   * @param args parameter required of every "application method" ('main' method)
   */
  public static void main(String[] args){
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        EspressoStandApp b = new EspressoStandApp();
      }
    });
  }  
  
    /**
     * This test method generates 3 orders, one using each of the 
     * different constructors, then "places" the orders.  One of 
     * three return values from processOrder is printed.  Finally,
     * an inventory report is requested and then the total sales are
     * checked using getTotalSales and printed.
     * 
     * This method also processes an order with a second ES object.
     * 
     * 142 STUDENTS: You SHOULD understand the code shown below.
     */
    public static void testEspressoStand( ) 
    {
        final String dashes = "---------------------------";
        EspressoStand es = new EspressoStand( );
        EspressoStand es2 = new EspressoStand( );
        Order order1 = new Order( );
        Order order2 = new Order( 2, 3 );
        Order order3 = new Order( 4, 3, 2, 1 );
        es.processOrder( order3 );
        es.processOrder( order2 );
        double price = es.processOrder( order1 );  // use return value
        es2.processOrder( new Order( 1, 2, 3, 4 ) );
        System.out.println( dashes );
        System.out.println( "Price for one Combo1 = " + price );
        System.out.println( dashes );
        System.out.println( "Contents of order #3:" );
        System.out.println( order3.getSingleShortCount( ) + " single short lattes" );
        System.out.println( order3.getDoubleShortCount( ) + " double short lattes" );
        System.out.println( order3.getDoubleTallCount( ) + " double tall lattes" );
        System.out.println( order3.getCookieCount( ) + " cookies" );
        System.out.println( dashes );
        System.out.println( es.getInventory( ) );
        double balance = es.getTotalSales( );
        System.out.println( dashes );
        System.out.println( "Total sales = " + balance );
        System.out.println( dashes );
        System.out.println( "This should be 20.94: " + es2.getTotalSales( ) );  
    }
    
    /* 
    Test results should look like this:
    
    ---------------------------
    Price for one Combo1 = 3.24
    ---------------------------
    Contents of order #3:
    4 single short lattes
    3 double short lattes
    2 double tall lattes
    1 cookies
    ---------------------------
    shots in stock: 977
    ounces of milk in stock: 7860
    cookies in stock: 990
    cups in stock: 985
    ---------------------------
    Total sales = 48.85
    ---------------------------
    This should be 20.94: 20.94
    
    */
   
}