import java.awt.*;
import javax.swing.*;

public class UseAnimatedRectPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setTitle("A panel with rectangles");
        
        AnimatedRectPanel panel = new AnimatedRectPanel();
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        frame.setVisible(true);
    }
}