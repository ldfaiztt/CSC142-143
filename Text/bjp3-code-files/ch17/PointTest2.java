import java.awt.*;
        
public class PointTest2 {
    public static void main(String[] args) {
        Point p = new Point(2, 8);
        System.out.println("p = " + p);
        p = change(p);
        System.out.println("now p = " + p);
    }
        
    public static Point change(Point q) {
        q.translate(3, 5);
        q = new Point(-7, -14);
        System.out.println("q = " + q);
        return q;
    }
}
