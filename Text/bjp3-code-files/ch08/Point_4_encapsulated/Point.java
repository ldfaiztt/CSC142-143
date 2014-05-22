// A Point object represents a pair of (x, y) coordinates.
// Fourth version: encapsulated.
// Class invariant: x >= 0 && y >= 0.

public class Point {
    private int x;
    private int y;

    // Constructs a new point with the given (x, y) location.
    // pre: initialX >= 0 && initialY >= 0
    public Point(int initialX, int initialY) {
        setLocation(initialX, initialY);
    }

    // Returns the distance between this point and (0, 0).
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    // Returns the x-coordinate of this point.
    public int getX() {
        return x;
    }

    // Returns the y-coordinate of this point.
    public int getY() {
        return y;
    }

    // Sets this point's (x, y) location to the given values.
    // pre: newX >= 0 && newY >= 0
    public void setLocation(int newX, int newY) {
        if (newX < 0 || newY < 0) {
            throw new IllegalArgumentException();
        }

        x = newX;
        y = newY;
    }

    // Shifts this point's location by the given amount.
    // pre: x + dx >= 0 && y + dy >= 0
    public void translate(int dx, int dy) {
        setLocation(x + dx, y + dy);
    }
}
