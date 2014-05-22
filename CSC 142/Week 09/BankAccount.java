/** 
 * BankAccount
 * Simulates a simple bank account object.
 * No checking for negative balance.
 * @author CSC 142
 * @version 1/3/06
 */
public class BankAccount {
  private String owner, acctID;
  private double balance;      

  /** 
   * Construct a BankAccount object.
   * @param name owner of the account
   * @param ID account ID
   * @param initialBalance starting balance, should be >= 0
   */
  public BankAccount( String name, String ID, double initialBalance ) {
    owner = name;
    acctID = ID;
    balance = initialBalance;
  }

  /** 
   * Get the owner of this account.
   * @return the owner of this account
   */ 
  public String getOwner( ) {
    return owner;
  }
  
  /** 
   * Get the account ID of this account.
   * @return the account ID of this account
   */ 
  public String getID( ) {
    return acctID;
  }
  
  /** 
   * Get the balance of this account.
   * @return the balance of this account
   */ 
  public double getBalance( ) {
    return balance;
  }
  
  /** 
   * Deposit money into this account.
   * @param amount amount to be deposited; should be >=0
   */
  public void deposit( double amount ){
    balance = balance + amount;
  }
  
  /** 
   * Withdraw money from the account.
   * @param amount amount to be withdrawn; should be <= this.getBalance( )
   */
  public void withdraw( double amount ) {
    balance = balance - amount;
  }
  
  /** 
   * Produce a String representation of this BankAccount. 
   * @return a String value representing this BankAccount
   */
  public String toString( ) {
      return "BankAccount owned by: " + owner + "    ID: " 
        + acctID + "    balance: $" + balance;
  }
}
