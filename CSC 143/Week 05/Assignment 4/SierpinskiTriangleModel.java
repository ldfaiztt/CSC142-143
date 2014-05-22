import java.util.*;
import java.awt.*;

/**
 * The model of the SierpinskiTriangle project.
 * @author Chun-Wei Chen
 * @version 02/12/12
 */
public class SierpinskiTriangleModel
{
  private int apexX;  // x coordinate of the location of the SierpinskiTriangle
  private int apexY;  // y coordinate of the location of the SierpinskiTriangle
  private int size;   // size of the SierpinskiTriangle
  private int level;  // level of the SierpinskiTriangle
  private ArrayList<SierpinskiTriangleView> viewers;  // a list of viwer
  
  /**
   * Constructs a SierpinskiTriangle.
   * @param x x coordinate of the location of the SierpinskiTriangle
   * @param y y coordinate of the location of the SierpinskiTriangle
   * @param size size of the SierpinskiTriangle
   * @throws IllegalArgumentException if size < 0
   */
  public SierpinskiTriangleModel(int x, int y, int size) {
    if (size < 0)
      throw new IllegalArgumentException("Size cannot be less than zero.");
    apexX = x;
    apexY = y;
    this.size = size;
    level = 1;
    viewers = new ArrayList<SierpinskiTriangleView>();
  }
  
  /**
   * Registers the interested viewers with the model.
   * @param v a SierpinskiTriangleView object
   * @throws NullPointerException if v refers to null
   */
  public void addViwer(SierpinskiTriangleView v) {
    if (v == null)
      throw new NullPointerException("Cannot passed in a null object as parameter.");
    viewers.add(v);
    v.levelChanged();
  }
  
  /**
   * Changes value of the level of the SierpinskiTriangle.
   * @param change the value of the level difference
   * @throws IllegalArgumentException if level + change <= 0
   */
  public void changeLevel(int change) {
    if (level + change <= 0)
      throw new IllegalArgumentException("Invalid level change.");
    level += change;
    for (SierpinskiTriangleView v : viewers)
      v.levelChanged();
  }
  
  /**
   * Returns value of the level of the SierpinskiTriangle.
   * @return the value of the level
   */
  public int getLevel() {
    return level;
  }
  
  /**
   * Draws the SierpinskiTriangle.
   * @param g a Graphics object
   */
  public void drawSierpinskiTriangle(Graphics g) {
    drawSierpinskiTriangle(apexX, apexY, size, level, g);
  }
  
  /**
   * A private recursive drawSierpinskiTriangle method, 
   * used by the public drawSierpinskiTriangle method.
   * @throws IllegalArgumentException if level <= 0
   */
  private void drawSierpinskiTriangle(int x, int y, int size, int level, Graphics g) {
    if (level <= 0)
      throw new IllegalArgumentException("Level cannot be less than zero.");
    if (level == 1) {
      Polygon triangle = new Polygon();
      triangle.addPoint(x, y);
      triangle.addPoint(x - size / 2, y + size);
      triangle.addPoint(x + size / 2, y + size);
      g.fillPolygon(triangle);
    } else {
      drawSierpinskiTriangle(x, y, size / 2, level - 1, g);
      drawSierpinskiTriangle(x - size / 4, y +  size / 2, size / 2, level - 1, g);
      drawSierpinskiTriangle(x +  size / 4, y +  size / 2, size / 2, level - 1, g);
    }
  }
}