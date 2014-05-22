/** 
 *  Inheritance/polymorphism/dynamic-dispatch sample
 *  csc142
 *  W06
 */
public class Test {
  public static void main( String[] args ) { 
    Collie lassie = new Collie( "Lassie" );
    Poodle puff = new Poodle( "Puff" );
    Siamese missy = new Siamese( "pet me" );
    Canine myPet;
    Mammal aPet;
    Object something;
    lassie.bark();
    lassie.grow();
    System.out.println( lassie.age );
    myPet = lassie;
    aPet = lassie;
    lassie.bark();
    myPet.bark();
    ( (Collie)aPet ).bark( "Woof" );
    myPet = lassie;
    aPet = puff;
    
    Mammal test = puff;
    test.grow( );
    test = missy;
    test.grow( );
    
    Petable pett = missy;
    missy.purr( );
    pett.petMe( );
    pett = lassie;
    
    //myPet = missy;
    //myPet = aPet;
    aPet = missy;
    if ( myPet instanceof Poodle )
      puff = (Poodle)myPet;
  }
}