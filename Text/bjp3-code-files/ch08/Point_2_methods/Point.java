// A Point object represents a pair of (x, y) coordinates.
// Second version: state and behavior.

public class Point {
    int x;
    int y;

    // Returns the distance between this point and (0, 0).
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    // Shifts this point's location by the given amount.
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
