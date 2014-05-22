// Draws a message several times using a static method.

import java.awt.*;

public class DrawStringMessage2 {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(200, 100);
        panel.setBackground(Color.YELLOW);

        Graphics g = panel.getGraphics();
        drawText(g);
    }

    public static void drawText(Graphics g) {
        for (int i = 0; i < 10; i++) {
            g.drawString("There is no place like home",
                         i * 5, 10 + i * 10);
        }
    }
}
