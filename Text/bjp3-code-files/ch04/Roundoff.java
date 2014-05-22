public class Roundoff {
    public static void main(String[] args) {
        double n = 1.0;
        for (int i = 1; i <= 10; i++) {
            n += 0.1;
            System.out.println(n);
        }
    }
}
