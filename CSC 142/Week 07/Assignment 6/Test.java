public class Test {
  public static void main(String[] args) {
    Home h = new Home();
    Condominium c = new Condominium();
    ResortCondo r = new ResortCondo();
    
    Object oh = h;
    Home hc = c;
    Home hr = r;
    ((ResortCondo)hr).hasSwimmingPool(); 
  }
}