import java.awt.*;
import javax.swing.*;

public class TwoButtons {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 200));
        frame.setTitle("Two buttons");

	// 2 rows, 3 columns
        frame.setLayout(new FlowLayout());
	JButton button1 = new JButton();
        button1.setText("I'm the first button");     
        
        JButton button2 = new JButton("The second button");
        button2.setBackground(Color.YELLOW);

	frame.add(button1);
	frame.add(button2);
	
        frame.setVisible(true);
    }
}
