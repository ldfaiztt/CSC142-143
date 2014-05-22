// A MeteredPoint object represents a Point that counts
// the total distance it has been moved.
public class MeteredPoint extends Point {
    private double totalDistance;

    // Constructs a new point with the given coordinates.
    public MeteredPoint(int x, int y) {
        super(x, y);
        totalDistance = 0.0;
    }

    // Returns the total distance traveled this point.
    public double getTotalDistance() {
        return totalDistance;
    }

    // Sets the location of this MeteredPoint object to the
    // given coordinates and accumulates the distance moved.
    public void setLocation(int x, int y) {
        // accumulate distance moved from old to new location
        int dx = x - getX();
        int dy = y - getY();
        totalDistance += Math.sqrt(dx * dx + dy * dy);

        super.setLocation(x, y);
    }
}
