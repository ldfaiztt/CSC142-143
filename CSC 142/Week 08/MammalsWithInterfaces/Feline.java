/** 
 *  Inheritance/polymorphism/dynamic-dispatch sample
 *  csc142
 *  W06
 */
public class Feline extends Mammal implements Tagged {
    private static final int[] yrs = { 0, 16, 24, 28, 32, 36, 40, 44, 48, 52,
                                      56, 60, 64, 67, 70, 72, 74, 76, 78, 80,
                                      82, 84, 86, 88, 90, 92, 94 };
    // ageing source: http://www.blakjak.demon.co.uk/cat_yrs.htm
    private String mind;
    public Feline( String m ) {
        super( );
        mind = m;
    }
    
    public void purr( ) {
        System.out.println( getName() + ": Feline purr (" + mind + ")" );
    }
  
    // choose next age in sequence
    public void grow( ) {
        int i = 0;
        while ( yrs[i] <= age && i < yrs.length-1 )
            i++;
        age = yrs[i];
    }
  
    /** OverRIDES the toString method in Object */
    public String toString( ) {
        return "I am a Feline named " + getName() + "and I have a mind "
               + " of my own (" + mind + ")" ;
    }  
  
    public String getEmergencyNumber( ) {
        return "1-800-cat-find";
    }

}