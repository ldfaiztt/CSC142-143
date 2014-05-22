import java.awt.*;
import javax.swing.*;

public class IconDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(250, 150);
        frame.setTitle("Icon demo");

        JButton button = new JButton();
        button.setText("Have a nice day");

        // create a smiley face icon for this button
        ImageIcon icon = new ImageIcon("smiley.jpg");
        button.setIcon(icon);

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(button);

        frame.add(panel, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}
