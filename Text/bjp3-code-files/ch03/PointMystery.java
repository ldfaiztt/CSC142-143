import java.awt.Point;

public class PointMystery {
    public static void method1(Point p) {
        int temp = p.x;
        p.x = p.y;
        p.y = temp;
    }
    
    public static Point method2(Point p) {
        p = new Point(-p.y, -p.x);
        return p;
    }
    
    public static void main(String[] args) {
        Point p1 = new Point(5, 2);
        Point p2 = new Point(-3, 6);
        
        method1(p1);
        method2(p2);
        Point p3 = method2(p1);

        System.out.println("(" + p1.x + ", " + p1.y + ")");
        System.out.println("(" + p2.x + ", " + p2.y + ")");
        System.out.println("(" + p3.x + ", " + p3.y + ")");
    }
}