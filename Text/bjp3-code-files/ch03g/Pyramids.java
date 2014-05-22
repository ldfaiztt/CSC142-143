// This program draws three colored pyramid figures.

import java.awt.*;

public class Pyramids {
    public static final int SIZE = 100;
    
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(350, 250);
        Graphics g = panel.getGraphics();
        
        drawPyramid(g, Color.WHITE, 0, 0, 10);
        drawPyramid(g, Color.RED, 80, 140, 5);
        drawPyramid(g, Color.BLUE, 220, 50, 20);
    }
    
    // Draws one pyramid figure with the given
    // number of stairs at the given x/y position
    // with the given color.
    public static void drawPyramid(Graphics g, Color c,
            int x, int y, int stairs) {

        // bounding rectangle
        g.drawRect(x, y, SIZE, SIZE);

        // stairs of the pyramid
        for (int i = 0; i < stairs; i++) {
            int stairHeight = SIZE / stairs;
            int stairWidth = stairHeight * (i + 1);
            int stairX = x + (SIZE - stairWidth) / 2;
            int stairY = y + stairHeight * i;
            
            // fill rectangle with fill color
            g.setColor(c);
            g.fillRect(stairX, stairY,
                       stairWidth, stairHeight);
            
            // draw black rectangle outline
            g.setColor(Color.BLACK);
            g.drawRect(stairX, stairY,
                       stairWidth, stairHeight);
        }
    }
}
