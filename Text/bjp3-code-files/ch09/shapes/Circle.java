// Represents circle shapes.
public class Circle implements Shape {
    private double radius;
    
    // Constructs a new circle with the given radius.
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // Returns the area of this circle.
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    // Returns the perimeter of this circle.
    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }
}
