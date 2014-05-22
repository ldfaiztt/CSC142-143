// The DrawingPanel class provides a simple interface for drawing persistent
// images using a Graphics object.

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;

public class DrawingPanel {
    public static final int DELAY = 250;  // ms delay between repaints

    private JFrame frame;         // overall window frame
    private JPanel panel;         // overall drawing surface
    private Graphics g;           // graphics context for painting
    private JLabel statusBar;     // status bar showing mouse position

    // constructs a drawing panel of given width and height enclosed in a window
    public DrawingPanel(int width, int height) {
        // set up the empty image onto which we will draw
        BufferedImage image = new BufferedImage(width, height,
        		BufferedImage.TYPE_INT_ARGB);
        g = image.getGraphics();
        g.setColor(Color.BLACK);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(image));

		panel = new JPanel();
		panel.setLayout(new FlowLayout(0, 0));
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(width, height));
        panel.add(label);

        // the status bar that shows the mouse position
        statusBar = new JLabel(" ");

        StatusBarMouseAdapter mouse = new StatusBarMouseAdapter();
        panel.addMouseListener(mouse);
        panel.addMouseMotionListener(mouse);

        // set up the JFrame
        frame = new JFrame("Drawing Panel");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.add(statusBar, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        frame.toFront();

        // start a repaint timer so that the screen will update
        TimerListener listener = new TimerListener();
        Timer timer = new Timer(DELAY, listener);
        timer.start();
    }

    // obtain the Graphics object to draw on the panel
    public Graphics getGraphics() {
        return g;
    }

    // set the background color of the drawing panel
    public void setBackground(Color c) {
        panel.setBackground(c);
    }

    // show or hide the drawing panel on the screen
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    // makes the program pause for the given amount of time, for animation
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }

    // makes drawing panel become the frontmost window on the screen
    public void toFront() {
        frame.toFront();
    }

    // used for an internal timer that repeatedly repaints the screen
    class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.repaint();
        }
    }

    // draws the status bar text when the mouse moves
    class StatusBarMouseAdapter extends MouseInputAdapter {
        public void mouseMoved(MouseEvent e) {
            statusBar.setText("(" + e.getX() + ", " + e.getY() + ")");
        }
    }
}
