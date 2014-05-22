// A GUI that displays the mouse position over a label.

import java.awt.*;
import javax.swing.*;

public class MousePointGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(200, 100));
        frame.setTitle("A frame");

        JLabel label = new JLabel();
        label.setText("Move the mouse over me!");
        frame.add(label);

        PointListener mListener = new PointListener();
        label.addMouseListener(mListener);
        label.addMouseMotionListener(mListener);

        frame.setVisible(true);
    }
}
