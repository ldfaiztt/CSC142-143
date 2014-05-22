import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// A panel that draws animated rectangles on its surface.
public class AnimatedRectPanel extends JPanel {
    private Point p1;  // location of first rectangle
    private Point p2;  // location of second rectangle
    private int dx;    // amount by which to change position horizontally
    private int dy;    // amount by which to change position vertically

    public AnimatedRectPanel() {
        p1 = new Point(20, 40);
        p2 = new Point(60, 10);
        dx = 5;
        dy = 5;

        // set up the timer to animate the motion of the rectangles
        RectangleMover mover = new RectangleMover();
        Timer time = new Timer(100, mover);  // update every 100 ms
        time.start();
    }

    // draws two rectangles on this panel on the screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // call JPanel's original version
        g.setColor(Color.RED);
        g.fillRect(p1.x, p1.y, 70, 30);
        g.setColor(Color.BLUE);
        g.fillRect(p2.x, p2.y, 20, 80);
    }

    // adjusts the position of both rectangles
    public void move() {
        p1.x += dx;
        p2.y += dy;
        if (p1.x <= 0 || p1.x + 70 >= getWidth()) {
            dx = -dx;  // rectangle 1 has hit left/right edge
        }
        if (p2.y <= 0 || p2.y + 80 >= getHeight()) {
            dy = -dy;  // rectangle 2 has hit top/bottom edge
        }
    }

    // redraws the rectangle panel at timed intervals
    public class RectangleMover implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            move();
            repaint();
        }
    }
}
