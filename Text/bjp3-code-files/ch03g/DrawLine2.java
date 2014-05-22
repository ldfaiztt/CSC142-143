// Draws three lines to make a triangle.

import java.awt.*;

public class DrawLine2 {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(200, 100);
        
        // draw a triangle on the panel
        Graphics g = panel.getGraphics();
        g.drawLine(25, 75, 100, 25);
        g.drawLine(100, 25, 175, 75);
        g.drawLine(25, 75, 175, 75);
    }
}
