import java.awt.*;
import javax.swing.*;

/**
 * Text view for a simple recursion demo that draws a pattern of dots.
 * Most Javadocs omitted.
 * 
 * CSC 143
 * W'12
 */ 
public class LevelLabelView extends JLabel implements DotView
{
  private DotModel model;
  
  public LevelLabelView(DotModel m) {
    model = m;
    m.register(this);
  }
  
  public void levelChanged() {
    int level = model.getLevel();
    int dots = (int)Math.pow(2, level);
    // Ref the "ternary operator" (conditional operator) for more info about ? :
    this.setText("Level " + level + " -- Each view shows " + dots + " dot"
                 + (dots == 1 ? "" : "s") + ".");
  }
}