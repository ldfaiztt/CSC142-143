import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Mouse motion listener to display (x, y) data on a label.
public class PointListener extends MouseInputAdapter {
    public void mouseMoved(MouseEvent event) {
        JLabel label = (JLabel) event.getSource();
        label.setText("(" + event.getX() + ", " + event.getY() + ")");
    }
}
