import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(200, 100));
        frame.setTitle("A frame");

        JButton button = new JButton("Click me");
        MessageListener listener = new MessageListener();
        button.addActionListener(listener);
        frame.add(button);

        frame.setVisible(true);
    }
}

// Responds to a button click event by displaying a message dialog box.
class MessageListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "You clicked the button!");
    }
}
