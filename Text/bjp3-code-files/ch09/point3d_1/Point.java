// A Point object represents a pair of (x, y) coordinates.
// Sixth version: multiple constructors and this keyword.
// Class invariant: x >= 0 && y >= 0.

public class Point {
    private int x;
    private int y;

    // Constructs a new Point object at the origin, (0, 0).
    public Point() {
        this(0, 0);    // calls Point(int, int) constructor
    }

    // Constructs a new Point with the given (x, y) position.
    // pre: x >= 0 && y >= 0
    public Point(int x, int y) {
        setLocation(x, y);
    }

    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    // Returns whether o refers to a Point with the same
    // (x, y) coordinates as this Point.
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point other = (Point) o;
            return x == other.x && y == other.y;
        } else {  // not a Point object
            return false;
        }
    }

    // Returns the x-coordinate of this Point.
    public int getX() {
        return x;
    }

    // Returns the y-coordinate of this Point.
    public int getY() {
        return y;
    }

    // Sets this Point's (x, y) location to the given values.
    // pre: x >= 0 && y >= 0
    public void setLocation(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }

        this.x = x;
        this.y = y;
    }

    // Returns a String representation of this Point object.
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public void translate(int dx, int dy) {
        setLocation(x + dx, y + dy);
    }
}
