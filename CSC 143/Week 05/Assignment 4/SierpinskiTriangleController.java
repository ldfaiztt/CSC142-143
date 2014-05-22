import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Controller for the SierpinskiTriangle project.
 * @author Chun-Wei Chen
 * @version 02/12/12
 */
public class SierpinskiTriangleController extends JPanel implements ActionListener
{
  public static final String LEVEL_UP = "Level Up";
  public static final String LEVEL_DOWN = "Level Down";
  
  private SierpinskiTriangleModel model; // a SierpinskiTriangle
  
  /**
   * Constructs a controller of the SierpinskiTriangle.
   * @param model a SierpinskiTriangleModel object
   * @throws NullPointerException if model refers to null
   */
  public SierpinskiTriangleController(SierpinskiTriangleModel model) {
    if (model == null)
      throw new NullPointerException("Cannot passed in a null object as parameter.");
    this.model = model;
    JButton levelDown = new JButton(LEVEL_DOWN);
    JButton levelUp = new JButton(LEVEL_UP);
    this.add(levelDown);
    this.add(levelUp);
    levelDown.addActionListener(this);
    levelUp.addActionListener(this);
    this.add(new SierpinskiTriangleLabelView(model));
  }
  
  /**
   * Changes the level of the SierpinskiTriangle.
   * The max level is 10 and the min level is 1.
   * @param e an ActionEvent object
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == LEVEL_UP) {
      if (model.getLevel() < 10) 
        model.changeLevel(1);
    }
    else if (model.getLevel() > 1)
      model.changeLevel(-1);
  }
}