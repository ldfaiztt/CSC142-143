/** BankAccount
 * Simulates a simple bank account object.
 * Addition of precondition checking so that account balance is never < 0
 * @author csc142
 * @version 2.0 
 */
public class BankAccount {
  private String owner, acctID;
  private double balance;    //class invariant:  must always be >= 0  

  /** Construct a BankAccount object 
   * @param name owner of the account
   * @param ID account ID
   * @param initialBalance starting balance
   * @throws IllegalArgumentException if initialBalance &lt; 0
   */
  public BankAccount(String name, String ID, double initialBalance){
      if (initialBalance < 0)
        throw new IllegalArgumentException("Cannot create a BankAccount with a negative balance");
     owner = name;
     acctID = ID;
     balance = initialBalance;
  }

  /** Returns the owner of this account */
  public String getOwner() {
    return owner;
  }
  
  /** Returns the account ID of this account */
  public String getID() {
    return acctID;
  }
  
  /** Returns the current balance */
  public double getBalance() {
    return balance;
  }
  
  /** Deposit money into this account.
   * @param amount amount to be deposited.  
   * @throws IllegalArgumentException if amount &lt; 0
   */
  public void deposit(double amount){
      if (amount < 0)
        throw new IllegalArgumentException("Cannot deposit a negative amount: " + amount);
      balance = balance + amount;
  }
  
  /** Withdraw money from the account.
   * @param amount amount to be withdrawn. 
   * @throws IllegalArgumentException if amount &gt; this.getBalance() or if amount &lt; 0
   */
  public void withdraw(double amount) {
    if (amount > balance)
        throw new IllegalArgumentException("Cannot withdraw more than the current balance of this BankAccount");
    if (amount < 0)
        throw new IllegalArgumentException("Cannot withdraw a negative amount: " + amount);
    balance = balance - amount;
  }
  
  /** String representation of this BankAccount
   */
  public String toString() {
      return "BankAccount owned by: " + owner + "    ID: " + acctID + "    balance: $" + balance;
    }
}
