// Presents a GUI to verify credit card numbers.
// Example valid numbers: 4111111111111111, 4408041234567893

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreditCardGUI {
    public static void main(String[] args) {
        new CreditCardGUI();
    }

    private JFrame frame;
    private JTextField numberField;
    private JLabel validLabel;
    private JButton verifyButton;

    public CreditCardGUI() {
        // set up components
        frame = new JFrame("Credit card number verifier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(350, 100));
        numberField = new JTextField(16);
        validLabel = new JLabel("not yet verified");
        verifyButton = new JButton("Verify CC Number");

        // event listeners
        verifyButton.addActionListener(new VerifyListener());

        // layout
        frame.setLayout(new FlowLayout());
        frame.add(numberField);
        frame.add(verifyButton);
        frame.add(validLabel);
        frame.setVisible(true);
    }

    // Returns whether the given string is a valid Visa card number
    // according to the Luhn checksum algorithm.
    public boolean isValidCreditCardNumber(String text) {
        if (!text.startsWith("4")) {
            return false;
        }

        // add all of the digits
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            int digit = Integer.valueOf(text.substring(i, i + 1));
            if (i % 2 == 0) {  // double every other number, add digits
                digit *= 2;
                sum += (digit / 10) + (digit % 10);
            } else {
                sum += digit;
            }
        }
        // valid numbers add up to a multiple of 10
        return (sum % 10 == 0);
    }

    // Sets the label's text to show whether the credit card number is valid.
    public class VerifyListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String text = numberField.getText();
            if (isValidCreditCardNumber(text)) {
                validLabel.setText("Valid number!");
            } else {
                validLabel.setText("Invalid number.");
            }
        }
    }
}
