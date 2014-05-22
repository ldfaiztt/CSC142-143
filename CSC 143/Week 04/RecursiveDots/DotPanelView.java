import java.awt.*;
import javax.swing.*;

/**
 * Graphical view for a simple recursion demo that draws a pattern of dots.
 * Most Javadocs omitted.
 * 
 * CSC 143
 * W'12
 */ 
public class DotPanelView extends JPanel implements DotView
{
  private Color dotColor;
  private DotModel model;
  
  public DotPanelView(DotModel m, Color c, int panelW, int panelH) {
    dotColor = c;
    model = m;
    m.register(this);
    this.setPreferredSize(new Dimension(panelW, panelH));
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(dotColor);
    model.drawDots(g);
  }
  
  public void levelChanged() {
    repaint();
  }
}