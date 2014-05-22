/**
 * Representation of an exempt employee.  An exempt employee is paid a salary.
 * 
 * @author CSC143
 * @version 10/9/09
 */
public class ExemptEmployee extends Employee
{
  private double salary;   // weekly salary.  Invariant:  Must be >= 0
  /**
   * Create an ExemptEmployee with the given data. 
   * @param name the employee's name
   * @param id the employee's id
   * @param salary the employee's weekly salary
   * @throws IllegalArgumentException if salary is &lt; 0
   */
  public ExemptEmployee(String name, int id, double salary)
  {
    super(name, id);
    if (salary < 0)
      throw new IllegalArgumentException("ExemptEmployee cannot have negative salary: " + salary);
    this.salary = salary;
  }
  
  /**
   * Set the weekly salary for this ExemptEmployee 
   * @param  salary the new weekly salary
   * @throws IllegalArgumentException if salary is &lt; 0
   */
  public void setSalary(double salary) {
    if (salary < 0)
      throw new IllegalArgumentException("ExemptEmployee cannot have negative salary: " + salary);
    this.salary = salary;
  }
  
  /** Return the weekly salary for this ExemptEmployee  */
  public double getPay(){
    return salary;
  }
}
