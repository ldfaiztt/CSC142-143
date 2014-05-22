import java.awt.*;
import javax.swing.*;

public class FlowLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(320, 75));
        frame.setTitle("Flow layout");

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Type your ZIP Code: "));
        frame.add(new JTextField(5));
        frame.add(new JButton("Submit"));

        frame.setVisible(true);
    }
}
