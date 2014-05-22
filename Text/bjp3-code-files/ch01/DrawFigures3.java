// Draws text figures.
// Third version that captures structure and redundancy.

public class DrawFigures3 {
    public static void main(String[] args) {
        drawDiamond();
        drawX();
        drawRocket();
    }

    public static void drawDiamond() {
        drawCone();
        drawV();
        System.out.println();
    }

    public static void drawX() {
        drawV();
        drawCone();
        System.out.println();
    }

    public static void drawRocket() {
        drawCone();
        drawBox();
        System.out.println("|United|");
        System.out.println("|States|");
        drawBox();
        drawCone();
        System.out.println();
    }

    public static void drawBox() {
        System.out.println("+------+");
        System.out.println("|      |");
        System.out.println("|      |");
        System.out.println("+------+");
    }

    public static void drawCone() {
        System.out.println("   /\\");
        System.out.println("  /  \\");
        System.out.println(" /    \\");
    }

    public static void drawV() {
        System.out.println(" \\    /");
        System.out.println("  \\  /");
        System.out.println("   \\/");
    }
}
