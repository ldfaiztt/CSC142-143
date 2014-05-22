import java.awt.*;
import java.awt.image.*;  // for BufferedImage
import javax.swing.*;

public class BufferedImageDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(250, 120);
        frame.setTitle("BufferedImage demo");

        JButton button = new JButton();
        button.setText("My drawing");

        // create a shape image icon for this button
        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.YELLOW);
        g.fillRect(10, 5, 80, 40);
        g.setColor(Color.RED);
        g.fillOval(40, 10, 25, 25);
        
        ImageIcon icon = new ImageIcon(image);
        button.setIcon(icon);

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(button);

        frame.setIconImage(image);
        frame.add(panel, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}
