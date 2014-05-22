public class DrawFigure {
    public static void main(String[] args) {
        drawLine();
        drawTop();
        drawBottom();
        drawLine();
    }

    // Produces a solid line
    public static void drawLine() {
        System.out.print("+");
        for (int i = 1; i <= 6; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    // This produces the top half of the hourglass figure
    public static void drawTop() {
        for (int line = 1; line <= 3; line++) {
            System.out.print("|");
            for (int i = 1; i <= (line - 1); i++) {
                System.out.print(" ");
            }
            System.out.print("\\");
            for (int i = 1; i <= (6 - 2 * line); i++) {
                System.out.print(".");
            }
            System.out.print("/");
            for (int i = 1; i <= (line - 1); i++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }

    // This produces the bottom half of the hourglass figure
    public static void drawBottom() {
        for (int line = 1; line <= 3; line++) {
            System.out.print("|");
            for (int i = 1; i <= (3 - line); i++) {
                System.out.print(" ");
            }
            System.out.print("/");
            for (int i = 1; i <= 2 * (line - 1); i++) {
                System.out.print(".");
            }
            System.out.print("\\");
            for (int i = 1; i <= (3 - line); i++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
}
