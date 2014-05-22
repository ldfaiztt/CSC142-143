import static javax.swing.JOptionPane.*;

public class UseOptionPanes2 {
    public static void main(String[] args) {
        String name = showInputDialog(null, "What is your name?");

        int choice = showConfirmDialog(null, "Do you like cake, " + name + "?");
        if (choice == YES_OPTION) {
            showMessageDialog(null, "Of course!  Who doesn't?");
        } else {
            // choice == JOptionPane.NO_OPTION or CANCEL_OPTION
            showMessageDialog(null, "We'll have to agree to disagree.");
        }
    }
}
