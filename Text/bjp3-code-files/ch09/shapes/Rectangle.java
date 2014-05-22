// Represents rectangle shapes.
public class Rectangle implements Shape {
    private double width;
    private double height;
    
    // Constructs a new rectangle with the given dimensions.
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Returns the area of this rectangle.
    public double getArea() {
        return width * height;
    }
    
    // Returns the perimeter of this rectangle.
    public double getPerimeter() {
        return 2.0 * (width + height);
    }
}
