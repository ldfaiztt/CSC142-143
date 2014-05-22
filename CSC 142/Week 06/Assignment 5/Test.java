public class Test {
  public static void main(String[] args) {
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
}