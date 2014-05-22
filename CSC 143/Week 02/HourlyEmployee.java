/**
 * Representation of an hourly employee.  An hourly employee is paid based on 
 * the number of hours worked and the hourly pay rate.
 * 
 * @author CSC143
 * @version 10/9/09
 */
public class HourlyEmployee extends Employee
{
  private double hoursWorked;  // number of hours worked in one week
  private double payRate;      // hourly pay rate
  
  /**
   * Create an HourlyEmployee with the given data. Currently no hours worked.
   * @param name the employee's name
   * @param id the employee's id
   * @param rate the employee's hourly pay rate.  Must be &gt; 0
   * @throws IllegalArgumentException if rate is &lt;= 0
   */
  public HourlyEmployee(String name, int id, double rate)
  {
    super(name, id);
    if (rate <= 0)
      throw new IllegalArgumentException("Illegal rate for HourlyEmployee: " + rate);
    payRate = rate;
    hoursWorked = 0;
  }
  
  /**
   * Add the hours worked for this HourlyEmployee to the current hourly total
   * @param  hrs the additional hours worked
   * @throws IllegalArgumentException if hrs &lt; 0
   */
  public void addHours(double hrs)
  {
    if (hrs < 0)
      throw new IllegalArgumentException("Cannot add these hours to HourlyEmployee: " + hrs);
    hoursWorked += hrs;
  }
  
  /**
   * Set the hourly rate for this HourlyEmployee
   * @param rate the new hourly rate
   * @throws IllegalArgumentException if rate is &lt;= 0
   */
  public void setRate(double rate) {
    if (rate <= 0)
      throw new IllegalArgumentException("Illegal rate for HourlyEmployee: " + rate);
    payRate = rate;
  }
  
  /**
   * Reset the hours worked to 0
   */
  public void resetHours() {
    hoursWorked = 0;
  }
  
  /** Return the number of hours this HourlyEmployee worked
    * @return the hours this HourlyEmployee worked
    */ 
  public double getHours() {
    return hoursWorked;
  }
  
  /** Return the hourly rate for this HourlyEmployee
    * @return the current pay rate for this HourlyEmployee
    */ 
  public double getRate() {
    return payRate;
  }
  
  /** Return the pay earned by this employee. Any hours over
    * 40 per week are considered "overtime" and paid at
    * "time and a half" (a 50% higher rate).
    * @return the gross pay for this HourlyEmployee
    */
  public double getPay(){
    if ( hoursWorked <= 0 )
      return 0.0;
    else if ( hoursWorked <= 40 )
      return hoursWorked * payRate;
    else
      return 40 * payRate + (hoursWorked-40) * 1.5 * payRate;
  }
  
  /**
   * The String representation of this HourlyEmployee
   */
  public String toString() {
    return super.toString() + "\nhours = " + hoursWorked + "\npay rate = " + payRate;
  }
}
