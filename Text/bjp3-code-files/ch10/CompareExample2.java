public class CompareExample2 {
    public static void main(String[] args) {
	String x = "hello";
	String y = "world";
	String z = "hello";
	System.out.println(x.compareTo(y));
	System.out.println(x.compareTo(z));
	System.out.println(y.compareTo(x));
    }
}
