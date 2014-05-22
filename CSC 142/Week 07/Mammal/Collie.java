/** In-class inheritance/polymorphism/dynamic-dispatch sample
 */
public class Collie extends Canine {
  public Collie( String n ) {
    super( n );
  }
  /** OverRIDES the bark method in Canine */
  public void myNoise( ) {
    System.out.println(getName() + " : Collie bark") ;
  }
  /** OverLOADS the bark method in Canine */
  public void myNoise( String emotion ) {
    System.out.println(getName() + ": Collie bark \"" + emotion + "\"" );
  }
}