/**
 * Sample controller for a really simple MVC example.
 * In this version of the simulation, each bank account is assigned
 * an individual account 'manager' (a controller) that implements
 * customized rules for the management of the account.  This idea 
 * could  be extended by extending the BankAccountManager class
 * and providing even more specialization.
 * Project BankAccountMVC2; most JavaDocs omitted.
 * @author CSC 143, VO
 * @version 1/20/04
 */
public class BankAccountManager {
  
  private BankAccount account;
  private double weeklySpending;
  private double monthlyRent;
  private double monthlyPay; 
  
  public BankAccountManager( BankAccount acc ) {
    account = acc;
    monthlyRent = 1200;
    monthlyPay = 2000;
    weeklySpending = 0;
  }
  
  public void setWeeklySpending( double amt ) {
    if ( amt >= 0 )
      weeklySpending = amt;
  }
  
  public void processOneDay( int day ) {
    if ( day == 10 || day == 25 )
      account.deposit( monthlyPay / 2 ); // deposit paycheck (half-month's pay)
    if ( day == 29 ) 
      account.withdrawal( monthlyRent ); // pay rent
    if ( day % 7 == 0 ) 
      account.withdrawal( weeklySpending ); // weekly spending (approx. as 4x per month)    
  }
  
}