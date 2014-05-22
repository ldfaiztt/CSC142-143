import java.awt.*;
import javax.swing.*;

/**
 * Text view for the SierpinskiTriangle project.
 * @author Chun-Wei Chen
 * @version 02/12/12
 */
public class SierpinskiTriangleLabelView extends JLabel implements SierpinskiTriangleView 
{
  
  private SierpinskiTriangleModel model; // a SierpinskiTriangleModel
  
  /**
   * Constructs a text view of the SierpinskiTriangle.
   * @param model a SierpinskiTriangleModel object
   * @throws NullPointerException if model refers to null
   */
  public SierpinskiTriangleLabelView(SierpinskiTriangleModel model) {
    if (model == null)
      throw new NullPointerException("Cannot passed in a null object as parameter.");
    this.model = model;
    model.addViwer(this); // Register to the model
  }
  
  /**
   * Changes the text view when level changes.
   */
  public void levelChanged() {
    int level = model.getLevel();
    int triangles = (int) Math.pow(3, level - 1);
    this.setText("Level " + level + " -- " + triangles + " triangle"
                 + (triangles == 1 ? "" : "s") + ".");
  }
}