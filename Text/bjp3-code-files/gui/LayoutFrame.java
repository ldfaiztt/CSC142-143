import java.awt.*;
import javax.swing.*;

public class LayoutFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        // frame.setContentPane(Box.createVerticalBox());
        frame.setTitle("FlowLayout");

        frame.add(new JButton("Button 1"), BorderLayout.NORTH);
        frame.add(new JButton("Button 2"), BorderLayout.WEST);
        frame.add(new JButton("Button 3"), BorderLayout.CENTER);
        frame.add(new JButton("Button 4"), BorderLayout.EAST);
        frame.add(new JButton("Wide Button 5"), BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
