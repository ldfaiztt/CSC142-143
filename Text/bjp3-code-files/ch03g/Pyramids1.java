import java.awt.*;

// Draws the first pyramid only, with a lot of redundancy.
public class Pyramids1 {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(350, 250);
        Graphics g = panel.getGraphics();
        
        // border rectangle
        g.drawRect(0, 0, 100, 100);
        
        // 10 "stairs" in pyramid
        g.drawRect(45,  0,  10, 10);
        g.drawRect(40, 10,  20, 10);
        g.drawRect(35, 20,  30, 10);
        g.drawRect(30, 30,  40, 10);
        g.drawRect(25, 40,  50, 10);
        g.drawRect(20, 50,  60, 10);
        g.drawRect(15, 60,  70, 10);
        g.drawRect(10, 70,  80, 10);
        g.drawRect( 5, 80,  90, 10);
        g.drawRect( 0, 90, 100, 10);
    }
}
