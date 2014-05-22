// This program draws several diamond figures of size 50x50.

import java.awt.*;

public class DrawDiamonds2 {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(360, 160);
        Graphics g = panel.getGraphics();

        drawManyDiamonds(g, 12, 15);
        g.setColor(Color.RED);
        drawManyDiamonds(g, 55, 100);
    }
    
    // Draws five diamonds in a horizontal line.
    public static void drawManyDiamonds(Graphics g,
                                        int x, int y) {
        for (int i = 0; i < 5; i++) {
            drawDiamond(g, x + 60*i, y);
        }
    }
        
    // draws a diamond in 50x50 box
    public static void drawDiamond(Graphics g,
                                   int x, int y) {
        g.drawRect(x, y, 50, 50);
        g.drawLine(x, y + 25, x + 25, y);
        g.drawLine(x + 25, y, x + 50, y + 25);
        g.drawLine(x + 50, y + 25, x + 25, y + 50);
        g.drawLine(x + 25, y + 50, x, y + 25);
    }
}
