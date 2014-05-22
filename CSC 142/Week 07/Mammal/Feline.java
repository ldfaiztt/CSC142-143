/** In-class inheritance/polymorphism/dynamic-dispatch sample
 */
public class Feline extends Mammal {
  private String mind;
  public Feline( String m ) {
    super( );
    mind = m;
  }
  public void myNoise( ) {
    System.out.println( getName() + ": Feline purr (" + mind + ")" );
  }
  /** OverRIDES the toString method in Object */
  public String toString( ) {
    return "I am a Feline named " + getName() + "and I have a mind "
      + " of my own (" + mind + ")" ;
  }  
}