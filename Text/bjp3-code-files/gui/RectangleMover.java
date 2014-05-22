import java.awt.event.*;

public class RectangleMover implements ActionListener {
    private AnimatedRectPanel panel;
    
    public RectangleMover(AnimatedRectPanel panel) {
        this.panel = panel;
    }

    public void actionPerformed(ActionEvent event) {
        panel.move();
        panel.repaint();
    }
}
