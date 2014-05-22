/** 
 *  Inheritance/polymorphism/dynamic-dispatch sample
 *  csc142
 *  W06
 */
public class Siamese extends Feline implements Petable {
    public Siamese( String m ) {
        super( m );
    }
  
    public void petMe( ) {
        purr( );
    }
}