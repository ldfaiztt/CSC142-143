// Draws and fills shapes in different colors.

import java.awt.*;

public class DrawColoredShapes {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(200, 100);
        panel.setBackground(Color.CYAN);

        Graphics g = panel.getGraphics();
        g.drawRect(150, 10, 40, 20);
        g.drawOval(50, 25, 20, 20);
        g.setColor(Color.WHITE);
        g.fillOval(150, 50, 40, 20);
        g.fillRect(25, 50, 20, 20);
    }
}
