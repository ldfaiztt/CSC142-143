/** 
 * Representation of a generic employee. 
 * 
 * NOTE: This is NOT the same as the Employee class in the
 * Reges textbook and is not related to it in any way.
 * Javadoc comments have been abbreviated to save space.
 * 
 * @author CSC143
 * @version 1/9/12
 */
public abstract class Employee {
  // instance variables
  private String name;           // employee name
  private int    id;             // employee id number
  
  /** 
   * Construct a new employee with the give name and id number
   * @param name the Employee's name
   * @param id the Employee's ID
   */
  public Employee(String name, int id) {
    this.name = name;
    this.id   = id;
  }
  
  /** Return the name of this employee */
  public String getName() { 
    return name; 
  }
  
  /** Return the id of this Employee */
  public int getId() {
    return id;
  }
  
  /** 
   * Set the name of this Employee
   * @param name the new name 
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /** Return a String representation of this Employee object. */
  public String toString() {
    return "Employee [# = " + id + "]  [name = " + name + "]";
  }
  
  /** Return the pay earned by this employee */
  public abstract double getPay( );
  
}
