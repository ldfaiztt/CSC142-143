import java.awt.*;
import javax.swing.*;

public class GridLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 120));
        frame.setTitle("The grid");

        // 2 rows, 3 columns
        frame.setLayout(new GridLayout(2, 3));
        for (int i = 1; i <= 6; i++) {
            JButton button = new JButton();
            button.setText("Button " + i);
            frame.add(button);
        }
        frame.setVisible(true);
    }
}
