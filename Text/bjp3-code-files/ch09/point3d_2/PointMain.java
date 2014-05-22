public class PointMain {
    public static void main(String[] args) {
        Point p = new Point(12, 7);
        Point3D p3d = new Point3D(12, 7, 11);
        System.out.println("p.equals(p3d) is " + p.equals(p3d));
        System.out.println("p3d.equals(p) is " + p3d.equals(p));
    }
}