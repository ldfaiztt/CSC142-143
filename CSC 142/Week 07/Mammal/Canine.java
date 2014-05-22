/** In-class inheritance/polymorphism/dynamic-dispatch sample
 */
public class Canine extends Mammal {
  public Canine( String n ) {
    super( n );
  }
  public void myNoise( ) {
    System.out.println(getName() + " : Canine bark");
  }
}