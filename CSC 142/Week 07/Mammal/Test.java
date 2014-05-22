public class Test {
  public static void main( String[] args ) { 
    Collie lassie = new Collie( "Lassie" );
    Poodle puff = new Poodle( "Puff" );
    Siamese missy = new Siamese( "pet me" );
    Canine myPet;
    Mammal aPet;
    Object something;
    lassie.myNoise();
    lassie.grow();
    System.out.println( lassie.getAge() );
    myPet = lassie;
    aPet = lassie;
    myPet.getName();
    myPet.myNoise();
    //aPet.myNoise();
    //aPet = puff;
    //myPet = missy;
    //myPet = aPet;
    //aPet = missy;
    //myPet = (Canine)aPet;
  }
}