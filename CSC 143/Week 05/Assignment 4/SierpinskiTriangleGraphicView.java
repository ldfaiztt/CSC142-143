import java.awt.*;
import javax.swing.*;

/**
 * Graphical view for the SierpinskiTriangle project.
 * @author Chun-Wei Chen
 * @version 02/12/12
 */
public class SierpinskiTriangleGraphicView extends JPanel implements SierpinskiTriangleView
{
  private SierpinskiTriangleModel model; // a SierpinskiTriangleModel
  private Color color;                   // the color of the SierpinskiTriangle
  
  /**
   * Constructs a graphical view of the SierpinskiTriangle
   * @param model a SierpinskiTriangleModel object
   * @param c the color of the SierpinskiTriangle
   * @param panelW the width of this panel
   * @param panelH the height of this panel
   * @throws NullPointerException if model or c refers to null
   * @throws IllegalArgumentException if panelW or panelH < 0
   */
  public SierpinskiTriangleGraphicView(SierpinskiTriangleModel model, Color c, 
                                       int panelW, int panelH) {
    if (model == null || c == null)
      throw new NullPointerException("Cannot passed in a null object as parameter.");
    if (panelW < 0 || panelH < 0)
      throw new IllegalArgumentException("Width and height cannot be less than zero.");
    this.model = model;
    color = c;
    model.addViwer(this);  // Register to the model
    this.setPreferredSize(new Dimension(panelW, panelH));
  }
  
  /**
   * Draws SierpinskiTriangles.
   * @param g a Graphics object
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(color);
    model.drawSierpinskiTriangle(g);
  }
  
  /**
   * Changes the graphical view when level changes.
   */
  public void levelChanged() {
    repaint();
  }
}