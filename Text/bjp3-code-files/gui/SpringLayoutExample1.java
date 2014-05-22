// Lays out two buttons using a SpringLayout.

import java.awt.*;
import javax.swing.*;

public class SpringLayoutExample1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 100));
        frame.setTitle("Spring layout");

        SpringLayout layout = new SpringLayout();
        frame.setLayout(layout);

        JButton button1 = new JButton();
        button1.setBackground(Color.BLUE);
        button1.setText("I'm a button.");
        frame.add(button1);

        JButton button2 = new JButton();
        button2.setBackground(Color.RED);
        button2.setText("Click me!");
        frame.add(button2);

        // keep button 1 at (5, 5)
        layout.putConstraint(SpringLayout.WEST, button1, 5,
                SpringLayout.WEST, frame.getContentPane());
        layout.putConstraint(SpringLayout.NORTH, button1, 5,
                SpringLayout.NORTH, frame.getContentPane());

        // keep button 2's bottom-right at (width-5, height-5)
        layout.putConstraint(SpringLayout.EAST, button2, -5,
                SpringLayout.EAST, frame.getContentPane());
        layout.putConstraint(SpringLayout.SOUTH, button2, -5,
                SpringLayout.SOUTH, frame.getContentPane());

        frame.setVisible(true);
    }
}
