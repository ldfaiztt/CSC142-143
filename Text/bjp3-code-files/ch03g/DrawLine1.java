// Draws a line onto a DrawingPanel.

import java.awt.*;   // for graphics

public class DrawLine1 {
    public static void main(String[] args) {
        // create the drawing panel
        DrawingPanel panel = new DrawingPanel(200, 100);
        
        // draw a line on the panel using
        // the Graphics paintbrush
        Graphics g = panel.getGraphics();
        g.drawLine(25, 75, 175, 25);
    }
}
