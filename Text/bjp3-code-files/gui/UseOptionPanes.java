// Shows several JOptionPane windows on the screen.

import javax.swing.*;   // for GUI components

public class UseOptionPanes {
    public static void main(String[] args) {
        // read the user's name graphically
        String name = JOptionPane.showInputDialog(null, 
                "What is your name?");

        // ask the user a yes/no question
        int choice = JOptionPane.showConfirmDialog(null, 
                "Do you like cake, " + name + "?");

        // show different response depending on answer
        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, 
                    "Of course!  Who doesn't?");
        } else {  // choice == NO_OPTION or CANCEL_OPTION
            JOptionPane.showMessageDialog(null,
                    "We'll have to agree to disagree.");
        }
    }
}
