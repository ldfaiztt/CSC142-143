/** 
 *  Inheritance/polymorphism/dynamic-dispatch sample
 *  csc142
 *  W06
 */
public class Collie extends Canine implements Petable, Tagged {

    public Collie( String n ) {
        super( n );
    }
    
    /** OverRIDES the bark method in Canine */
    public void bark( ) {
        System.out.println( getName() + ": Collie bark" );
    }
    
    /** OverLOADS the bark method in Canine */
    public void bark( String emotion ) {
        System.out.println( getName() + ": Collie bark \"" + emotion + "\"" );
    }
  
    public void petMe( ) {
      System.out.println( "Pet me again" );
    }
  
    public String getEmergencyNumber( ) {
        return "1-888-collies";
    }
}