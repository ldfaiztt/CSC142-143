/**
 * A Savings Account is a BankAccount that also accrues interest
 * 
 * @author csc142
 */
public class SavingsAccount extends BankAccount
{
    // balance, owner, and acctID are inherited
    // do not redeclare!
    private double interestRate,    // stored as a decimal 0 <= rate < 1
                   interestEarned;  // how much interest has accumulated in  this account
    
    /**
     * Create a SavingsAccount object with the given state.
     * @param name owner's name
     * @param id account id
     * @param balance initial balance, must be >= 0
     * @param rate interest rate as a decimal.  0 >= rate > 1
     * @throws IllegalArgumentException for bad balance or bad rate
     */
    public SavingsAccount(String name, String id, double balance, double rate) {
            // first line MUST be a call to the base class constructor using the keyword super
            // the argument list must match the parameter list of the base class constructor
            // since the BankAccount constructor checks for a bad balance, we don't need to check
            // for it here
            super(name, id, balance);
            
            if (rate < 0 || rate >= 1)
                throw new IllegalArgumentException("Bad rate " + rate);
            interestRate = rate;
            interestEarned = 0;
    }
    
    // All methods from BankAccont are inherited, so don't repeat them here!
    
    /** returns current rate
     * @return interest rate
     */
    public double getRate() { 
        return interestRate; 
    }
    
    /** returns earned interested
     * @return accumulated interest since opening
     */
    public double getEarnedInterest() { 
        return interestEarned; 
    }
    
    /**
     * Set the current interest rate
     * @param rate decimal rate in the range [0, 1)
     * @throws IllegalArgumentException for bad rate
     */
    public void setRate(double rate) {
        if (rate < 0 || rate >= 1)
                throw new IllegalArgumentException("Bad rate " + rate);
            interestRate = rate;
    }
    
    /**
     * Add earned interest to this account.  
     * Calculation is based on compound annually
     * (so entire rate is used).
     */
    public void earnInterest() {
        // cannot access the instance variable that is private in the base
        // class, so call the method to get that value
        double bal = getBalance();  // bal is NOT the instance  variable
        double interest = bal * interestRate;
        deposit(interest);         // update the balance instance variable
        interestEarned += interest;
    }
    
    //overriding the "would-be" inherited method
    /**
     * returns String representation of this SavingsAccount
     */
    public String toString() {
      String output = super.toString();
      output = output.substring(4);
      output = "Savings" + output;
      return output + ", interest rate: " + interestRate + ", interest earned: " + interestEarned;
    }
       
}
