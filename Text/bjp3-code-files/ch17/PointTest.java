import java.awt.*;
        
public class PointTest {
    public static void main(String[] args) {
        Point p = new Point(2, 8);
        System.out.println("p = " + p);
        change(p);
        System.out.println("now p = " + p);
    }
        
    public static void change(Point q) {
        q.translate(3, 5);
        q = new Point(-7, -14);
        System.out.println("q = " + q);
    }
}
