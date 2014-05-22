public class DrawFiveBoxes {
    public static void main(String[] args) {
        drawTwoBoxes();
        System.out.println();
        drawBox();
        System.out.println();
        drawTwoBoxes();
    }

    public static void drawTwoBoxes() {
        drawBox();
        drawBox();
    }
    
    public static void drawBox() {
        System.out.println("+------+");
        System.out.println("|      |");
        System.out.println("+------+");
    }
}
