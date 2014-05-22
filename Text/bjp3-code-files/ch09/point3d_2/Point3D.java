// A Point3D object represents an (x, y, z) location.

public class Point3D {
    private Point xy;
    private int z;
    
    public Point3D(int x, int y, int z) {
        xy = new Point(x, y);
        this.z = z;
    }
    
    // Returns the x-coordinate of this Point3D.
    public int getX() {
        return xy.getX();
    }
    
    // Returns the y-coordinate of this Point3D.
    public int getY() {
        return xy.getY();
    }
    
    // Returns the z-coordinate of this Point3D.
    public int getZ() {
        return z;
    }
    
    // Returns true if o is a Point3D object with the same
    // (x, y, z) coordinates as this Point3D object.
    public boolean equals(Object o) {
        if (o instanceof Point3D) {
            Point3D p = (Point3D) o;
            return xy.equals(p.xy) && z == p.z;
        } else {   // not a Point3D object
            return false;
        }
    }
}
