import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Mouse adapter to show a message dialog on each mouse event.
public class MovementAdapter extends MouseInputAdapter {
    public void mouseEntered(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "Mouse entered!");
    }
}
