// Represents triangle shapes.
public class Triangle implements Shape {
    private double a;
    private double b;
    private double c;
    
    // Constructs a new Triangle given side lengths.
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    // Returns this triangle's area using Heron's formula.
    public double getArea() {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // Returns the perimeter of this triangle.
    public double getPerimeter() {
        return a + b + c;
    }
}
