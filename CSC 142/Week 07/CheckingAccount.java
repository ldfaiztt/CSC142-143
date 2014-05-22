/**
 * A version of a bank account that assesses a service 
 * charge when a minumum amount has been breached.  
 * 
 * @author CSC 142
 */
public class CheckingAccount extends BankAccount {

    // instance variables
    private double lowBalance;      // the lowest balance since account opened or when
                                    // last service charge was deducted
    
    /**
     * Construct a new CheckingAccount with the given name, account number,
     * and initial balance
     * @throws IllegalArgumentException if  initialBalance < 0
     */
    public CheckingAccount(String name, String number, double initialBalance){
      super(name, number, initialBalance);
 
        //Left as an exercise for you
        
    }

 /**
 * Withdraw money from this account
 * @param request amount to be withdrawn
 * @throws IllegalArgumentException if amount <0 or amount > balance
 */
 public void withdraw(double request) {
   // think about what this does.  How is it the same as the inherited version
   // how does it differ? What about updating that new instance variable?
   
   
   
   

 }
    /**
     * Deduct a service charge if the account balance has gotten too low
     * since the last time a service charge was deducted (or the account
     * created, whichever comes first).
     * 
     * @param  minBalance minimum account balance before service 
     *         charge applies
     * @param  serviceCharge amount to deduct if charge applies
     */
    public void deductServiceCharge(double minBalance, double serviceCharge){
        if (this.lowBalance < minBalance) {
            this.withdraw(serviceCharge);
        }
        // update the instance variable.  The current balance is now the lowest
        // so far
        lowBalance = this.getBalance();
    }
    
        //overriding the "would-be" inherited method
    /**
     * returns String representation of this CheckingAccount
     */
    public String toString() {
      String output = super.toString();
      output = output.substring(4);
      output = "Checking" + output;
      return output;
    }
    
    // trace through this code
    public static void test() {
        CheckingAccount c = new CheckingAccount("Sally", "2", 500);
        c.deposit(40);
        double b = c.getBalance();
        c.withdraw(250);
        c.deductServiceCharge(300, 7.50);
        b = c.getBalance();
    }
}
