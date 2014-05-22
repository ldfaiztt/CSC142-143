import java.awt.*;

public class PointExample2 {
    public static void main(String[] args) {
        // declare variables and construct objects
        Point p1 = new Point(3, 8);
        Point p2 = new Point();
        Point p3 = p2;

        // see what is in each point initially
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
        System.out.println();

        // three translations
        p1.translate(-1, -2);
        p2.translate(4, 8);
        p3.translate(2, 3);

        // see what is in each point now
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
    }
}
