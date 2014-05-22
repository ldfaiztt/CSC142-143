public class UsePoint {
    public static void main(String[] args) {
        // This client code breaks the object's invariant.
        Point p = new Point(5, 4);
        p.x = -7;
        p.y = -3;
        System.out.println("Haha, I set its state to " + p);
    }
}