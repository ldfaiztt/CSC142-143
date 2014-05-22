public class UsePoint {
    // Using Point class from java.awt package
    public static void main(String[] args) {
        Point p = new Point();
        p.x = 3;
        p.y = 8;
        p.translate(2, -1);
        System.out.println("(" + p.x + ", " + p.y + ")");
    }
}