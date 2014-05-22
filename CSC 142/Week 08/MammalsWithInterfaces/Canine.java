/** 
 *  Inheritance/polymorphism/dynamic-dispatch sample
 *  csc142
 *  W06
 */
public class Canine extends Mammal {
    public Canine( String n ) {
        super( n );
    }
    
    public void bark( ) {
        System.out.println( getName() + ": Canine bark" );
    }
  
    public void grow( ) {
        age = age + 7;    
    }
}