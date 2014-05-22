public class Bad {
    // A static method to translate a Point.
    // Not a good model to follow.
    public static void translate(Point p, int dx, int dy) {
        p.x += dx;
        p.y += dy;
    }
}
