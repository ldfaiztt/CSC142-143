public class OutOfBoundsExample {
    public static void main(String[] args) {
        indexOf('x', "Vixen");
        indexOf('x', "Marty Stepp");
    }
    
    public static int indexOf(char ch, String s) {
        for (int i = 0; i <= s.length(); i++) {
            if (s.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }
}
