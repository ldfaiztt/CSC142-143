/** In-class inheritance/polymorphism/dynamic-dispatch sample
 *   Vince Offenback
 */
public class Mammal {
  private String name;
  private int age; 
  public Mammal( ) {
    name = "";
    age = 0;
  }
  public Mammal( String n ) {
    name = n;
    age = 0;
  }
  public void grow( ) {
    age++;
  }
  public String getName( ) {
    return name;
  }
  public void setName( String n ) {
    name = n;
  }
  public int getAge() {
      return age;
  }
  public void myNoise() {
      System.out.println(name + " : sh");
 }
}