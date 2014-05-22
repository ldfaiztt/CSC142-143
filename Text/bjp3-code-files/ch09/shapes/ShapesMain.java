// Demonstrates shape classes.
public class ShapesMain {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(18, 18);
        shapes[1] = new Triangle(30, 30, 30);
        shapes[2] = new Circle(12);
        
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("area=" + shapes[i].getArea() +
                               ", perimeter=" + 
                               shapes[i].getPerimeter());
        }
    }
}
