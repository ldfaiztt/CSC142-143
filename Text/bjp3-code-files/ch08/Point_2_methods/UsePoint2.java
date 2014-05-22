// Using our Point class
public class UsePoint2 {
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.x = 3;
        p1.y = 8;

        Point p2 = new Point();
        p2.x = 5;
        p2.y = 2;

        p1.translate(2, -1);
        p2.translate(4, 3);

        System.out.println("(" + p1.x + ", " + p1.y + ")");
        System.out.println("(" + p2.x + ", " + p2.y + ")");
    }
}