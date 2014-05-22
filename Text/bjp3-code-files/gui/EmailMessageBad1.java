import java.awt.*;
import javax.swing.*;

public class EmailMessageBad1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 300));
        frame.setTitle("Send Message");

        frame.setLayout(new BorderLayout());

	JPanel north = new JPanel(new GridLayout(3, 3));
	north.add(new JLabel("From: "));
	north.add(new JTextField());
	north.add(new JButton("Browse..."));
	north.add(new JLabel("To: "));
	north.add(new JTextField());
	north.add(new JButton("Browse..."));
	north.add(new JLabel("Subject: "));
	north.add(new JTextField());

	frame.add(north, BorderLayout.NORTH);
	frame.add(new JTextArea(), BorderLayout.CENTER);
	frame.add(new JButton("Send"), BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
