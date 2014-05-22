import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Controller for a simple recursion demo that draws a pattern of dots.
 * Notice that the controller includes the button panel and the event
 * handler code.  Most Javadocs omitted.
 * 
 * CSC 143
 * W'12
 */ 
public class DotController extends JPanel implements ActionListener
{
  public static final String UP = "Up";
  public static final String DOWN = "Down";
  
  private DotModel model;
  
  public DotController(DotModel m) { 
    model = m;
    JButton up = new JButton(UP);
    JButton down = new JButton(DOWN);
    this.add(up);
    this.add(down);
    up.addActionListener(this);
    down.addActionListener(this);
    this.add(new LevelLabelView(m));
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == UP)
      model.changeLevel(1);
    else if (model.getLevel() > 0)
      model.changeLevel(-1);
  }
  
  public static void main(String[] args) {
    // setup window
    JFrame win = new JFrame(); 
    win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    DotModel m = new DotModel(0, 20, 10, 256, 256); // initial dot
    win.getContentPane().add(new DotPanelView(m, Color.RED, 300, 280),
                             BorderLayout.EAST);
    win.getContentPane().add(new DotPanelView(m, Color.GREEN, 300, 280),
                             BorderLayout.WEST);
    win.getContentPane().add(new DotController(m), BorderLayout.SOUTH);
    win.pack();
    win.setVisible(true);
  }
}