import java.awt.*;
import java.util.*;

public class Koch {
    public static final int SIZE = 256;
    public static final double m = Math.sqrt(3.0) / 6.0;

    public static void main(String[] args) {
        // prompt for level
        Scanner console = new Scanner(System.in);
        System.out.print("What level do you want? ");
        int level = console.nextInt();

        // initialize drawing panel
	int deltaY = (int) Math.round(SIZE * Math.sqrt(3.0) / 2.0);
	int height = (int) (deltaY + m * SIZE);
	DrawingPanel p = new DrawingPanel(SIZE, height);
        p.setBackground(Color.CYAN);
	Graphics g = p.getGraphics();

	Point p1 = new Point(0, deltaY);
	Point p2 = new Point(SIZE / 2, 0);
	Point p3 = new Point(SIZE, deltaY);
	drawEdge(level, g, p1, p2);
	drawEdge(level, g, p2, p3);
	drawEdge(level, g, p3, p1);
    }

    public static void drawEdge(int level, Graphics g, Point p1, Point p2) {
	if (level == 1) {
	    g.drawLine(p1.x, p1.y, p2.x, p2.y);
	} else {
	    int deltaX = p2.x - p1.x;
	    int deltaY = p2.y - p1.y;
	    Point p3 = new Point(p1.x + deltaX / 3, p1.y + deltaY / 3);
	    Point p4 = new Point(p1.x + (int) (deltaX / 2.0 + m * deltaY),
				 p1.y + (int) (deltaY / 2.0 - m * deltaX));
	    Point p5 = new Point(p1.x + 2 * deltaX / 3, p1.y + 2 * deltaY / 3); 
	    drawEdge(level - 1, g, p1, p3);
	    drawEdge(level - 1, g, p3, p4);
	    drawEdge(level - 1, g, p4, p5);
	    drawEdge(level - 1, g, p5, p2);
	}
    }
}
