import java.awt.*;
import javax.swing.*;

public class ToolbarDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(250, 100);
        frame.setTitle("Toolbar demo");

        JToolBar toolbar = new JToolBar();
        toolbar.add(new JButton("New"));
        toolbar.add(new JButton("Open"));
        toolbar.add(new JButton("Save"));
        toolbar.add(new JButton("Quit"));

        frame.add(toolbar, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}
