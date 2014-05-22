/*
 * Chun-Wei Chen
 * CSC142.04.F11
 * Assignment #1
 */

public class TheHouseThatJackBuilt {
  public static void main(String[] args) {
    System.out.println("This is the house that Jack built.\n");
    System.out.println("This is the malt");
    house();
    System.out.println("This is the rat,");
    malt();
    System.out.println("This is the cat,");
    mouse();
    System.out.println("This is the dog,");
    cat();
    System.out.println("This is the cow with the crumpled horn,");
    dog();
    System.out.println("This is the maiden all forlorn ");
    cow();
    System.out.println();
  }
  
  public static void house() {
    System.out.println("That lay in the house that Jack built.\n");    
  }
  
  public static void malt() {
    System.out.println("That ate the malt");
    house();
  }
  
  public static void mouse() {
    System.out.println("That killed the rat,");
    malt();
  }
  
  public static void cat() {
    System.out.println("That worried the cat,");
    mouse();
  }
  
  public static void dog() {
    System.out.println("That tossed the dog,");
    cat();
  }
  
  public static void cow() {
    System.out.println("That milked the cow with the crumpled horn,");
    dog();
  }
}