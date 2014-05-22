import java.awt.*;
import javax.swing.*;

public class UseRectPanel2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setTitle("A panel with rectangles");
        frame.setLayout(new BorderLayout());
        
        JPanel north = new JPanel(new FlowLayout());
        north.add(new JLabel("Type your name:"));
        north.add(new JTextField(10));
        frame.add(north, BorderLayout.NORTH);
        
        frame.add(new JButton("Submit"), BorderLayout.SOUTH);
        
        RectPanel panel = new RectPanel();
        panel.setBackground(Color.WHITE);
        frame.add(panel, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
}