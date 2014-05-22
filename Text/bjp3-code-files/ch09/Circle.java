// Represents circle shapes.
public class Circle {
    private Point center;
    private double radius;
    
    // Constructs a new circle with the given radius.
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    
    // Returns the area of this circle.
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
