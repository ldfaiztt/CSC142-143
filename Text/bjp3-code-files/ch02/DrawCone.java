public class DrawCone {
    public static void main(String[] args) {
        for (int line = 5; line >= 1; line--) {
            for (int i = 1; i <= (line - 1); i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= (11 - 2 * line); i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
