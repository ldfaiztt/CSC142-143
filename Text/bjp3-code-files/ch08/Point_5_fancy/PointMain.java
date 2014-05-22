// A program that deals with 2D points.
// Fifth version, to accompany Point class with toString method.

public class PointMain {
    public static void main(String[] args) {
        // create two Point objects
        Point p1 = new Point(7, 2);
        Point p2 = new Point(4, 3);

        // print each point and its distance from origin
        System.out.println("p1 is " + p1);
        System.out.println("distance from origin = " +
                           p1.distanceFromOrigin());

        System.out.println("p2 is " + p2);
        System.out.println("distance from origin = " +
                           p2.distanceFromOrigin());

        // translate each point to a new location
        p1.translate(11, 6);
        p2.translate(1, 7);

        // print the points again
        System.out.println("p1 is " + p1);
        System.out.println("p2 is " + p2);
    }
}
