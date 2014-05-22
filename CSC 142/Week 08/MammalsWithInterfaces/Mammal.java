/** 
 *  Inheritance/polymorphism/dynamic-dispatch sample
 *  csc142
 *  W06
 */
public abstract class Mammal {
    private String name;
    // protected access: subclasses have direct access, but not public
    protected int age; 
    public Mammal( ) {
        name = "";
        age = 0;
    }
    public Mammal( String n ) {
        name = n;
        age = 0;
    }
  
    public String getName( ) {
        return name;
    }
    
    public void setName( String n ) {
        name = n;
    }
    
    // abstract method -- must be implemented by concrete subclasses
    public abstract void grow( );
}