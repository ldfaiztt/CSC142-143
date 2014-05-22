import java.util.ArrayList;
import java.awt.*;

/**
 * Model for a simple recursion demo that draws a pattern of dots.
 * Most Javadocs omitted.
 * 
 * CSC 143
 * W'12
 */ 
public class DotModel
{
  private int level;
  private int baseX;
  private int baseY;
  private int baseW;
  private int baseH;
  private ArrayList<DotView> viewers;
  
  public DotModel(int initialLevel, int x, int y, int w, int h) {
    if (w < 2 || h < 2 || initialLevel < 0) throw new IllegalArgumentException();
    level = initialLevel;
    baseX = x;
    baseY = y;
    baseW = w;
    baseH = h;
    viewers = new ArrayList<DotView>();
  }
  
  public void register(DotView v) {
    if (v == null) throw new NullPointerException();
    viewers.add(v);
    v.levelChanged();
  }
  
  public void changeLevel(int change) {
    if (level + change < 0) throw new IllegalArgumentException();
    level = level + change;
    for (DotView v : viewers)
      v.levelChanged();
  }
  
  public int getLevel() {
    return level;
  }
  
  /**
   * NON-recursive public entry method for drawing dots.
   */
  public void drawDots(Graphics g) {
    drawDot(level, baseX, baseY, baseW, baseH, g);
  }
  
  /**
   * RECURSIVE private method for drawing dots.
   */
  private void drawDot(int level, int x, int y, int w, int h,
                       Graphics g) {
    if (level < 0) throw new IllegalArgumentException();
    if (level == 0) // BASE case
      g.fillOval(x, y, w, h);
    else if (level % 2 == 1) { // odd level -- split VERTICAL
      drawDot(level-1, x, y, w/2, h, g); // draw left dot
      drawDot(level-1, x + w/2, y, w/2, h, g); // draw right dot
    } else { // odd level -- split HORIZONTAL
      drawDot(level-1, x, y, w, h/2, g); // draw top dot
      drawDot(level-1, x, y + h/2, w, h/2, g); // draw bottom dot
    }
      
  }
}