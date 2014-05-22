// A "client" program that uses our Point class.
public class UsePoint {
    public static void main(String[] args) {
        // create two Point objects
        Point p1 = new Point();
        p1.x = 5;
        p1.y = -2;

        Point p2 = new Point();
        p2.x = -4;
        p2.y = 3;

        // print each point
        System.out.println("(" + p1.x + ", " + p1.y + ")");
        System.out.println("(" + p2.x + ", " + p2.y + ")");
    }
}