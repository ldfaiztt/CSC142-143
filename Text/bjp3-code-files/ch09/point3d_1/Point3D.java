// A Point3D object represents an (x, y, z) location.
// Not a good design to follow.

public class Point3D extends Point {
    private int z;
    
    // Constructs a new 3D point with the given coordinates.
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    
    // Returns the z-coordinate of this Point3D.
    public int getZ() {
        return z;
    }
}
