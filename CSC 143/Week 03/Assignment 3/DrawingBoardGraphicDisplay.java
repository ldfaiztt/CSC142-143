import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * A graphic view version of the DrawingBoard.
 * @author Chun-Wei Chen
 * @version 02/03/12
 */
public class DrawingBoardGraphicDisplay extends JPanel
  implements DrawingBoardViewer
{
  private DrawingBoard dBoard; // a DrawingBoard object
  
  /**
   * Constructs a DrawingBoardGraphicDisplay object.
   * @param db a DrawingBoard object
   * @throws IllegalArgumentException if db is null
   */
  public DrawingBoardGraphicDisplay(DrawingBoard db) {
    if (db == null)
      throw new IllegalArgumentException("Argument cannot be null.");
    dBoard = db;
    dBoard.addViewer(this); // Regeister to the DrawingBoard
    this.setLayout(new BorderLayout());
    JSlider slider = new JSlider(0, 100, 50);
    slider.setMajorTickSpacing(10);
    slider.setPaintTicks(true);
    JLabel label = new JLabel ("Size: 50");
    DrawingBoardControl controller = new DrawingBoardControl(dBoard, slider, label);
    addMouseListener(controller);  // Listen to the MouseListener
    addMouseMotionListener(controller); // Listen to the MouseMotionListener
    
    // Construct radio buttons
    JRadioButton circleButton = new JRadioButton("Circle");
    circleButton.setSelected(true);
    JRadioButton deltaButton = new JRadioButton("Delta");
    JRadioButton teeButton = new JRadioButton("Tee");
    JRadioButton notAddingShapeButton = new JRadioButton("Not Adding Shape");
    
    // Group the radio buttons.
    ButtonGroup group = new ButtonGroup();
    group.add(circleButton);
    group.add(deltaButton);
    group.add(teeButton);
    group.add(notAddingShapeButton);
    
    // Register a listener for the radio buttons.
    circleButton.addActionListener(controller);
    deltaButton.addActionListener(controller);
    teeButton.addActionListener(controller);
    notAddingShapeButton.addActionListener(controller);
    
    // Put the radio buttons into a panel.
    JPanel buttons = new JPanel();
    buttons.add(circleButton);
    buttons.add(deltaButton);
    buttons.add(teeButton);
    buttons.add(notAddingShapeButton);
    
    // Add buttons, slider, and label into the same panel.
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(buttons, BorderLayout.NORTH);
    panel.add(slider, BorderLayout.CENTER);
    panel.add(label, BorderLayout.SOUTH);

    // Add the panel into DrawingBoardGraphicDisplay.
    add(panel, BorderLayout.SOUTH);
  }

  /**
   * Changes the graphic display after the changes occur in the model.
   */
  public void shapeListChanged() {
    repaint();
  }
  
  /**
   * Overrides the method inherited from JPanel to draw graphics.
   * Draws every shape stored in the shapeList of the DrawingBoard on the window.
   * @param g the Graphics object
   */
  public void paintComponent(Graphics g) {
    // Call the superclass paintComponent method.
    super.paintComponent(g);

    for (Shape s : dBoard.getShapeList()) {
      // s is a Circle
      if (s instanceof Circle) {
        Circle c = (Circle) s;
        g.setColor(Color.red);
        c.setColor(Color.red);
        g.fillOval(c.upperLeftX, c.upperLeftY, c.height, c.height); // draw Circle
        
        // If this is selected shape, draw black outline.
        if (c == dBoard.getSelectedShape()) {
           g.setColor(Color.black);
          g.drawOval(c.upperLeftX, c.upperLeftY, c.height, c.height);
        }
      }
      
      // s is a Delta
      else if (s instanceof Delta) {
        Delta d = (Delta) s;
        g.setColor(Color.yellow);
        d.setColor(Color.yellow);
        
        // Use Polygon object to hold three points of the Delta.
        Polygon delta = new Polygon();
        delta.addPoint(d.upperLeftX + d.height / 2, d.upperLeftY);
        delta.addPoint(d.upperLeftX, d.upperLeftY + d.height);
        delta.addPoint(d.upperLeftX + d.height, d.upperLeftY + d.height);
        g.fillPolygon(delta); // draw Delta
        
        // If this is selected shape, then draw black outline.
        if (d == dBoard.getSelectedShape()) {
          g.setColor(Color.black);
          g.drawPolygon(delta);
        }
      }
      
      // s is a Tee
      else {
        Tee t = (Tee) s;
        g.setColor(Color.green);
        t.setColor(Color.green);
        
        // draw the top of the Tee
        g.fillRect(t.upperLeftX, t.upperLeftY, t.height, t.height / 5);
        // draw the bottom of the Tee
        g.fillRect(t.upperLeftX + 2 * t.height / 5, t.upperLeftY + t.height / 5,
                   t.height / 5, 4 * t.height / 5);
        
        // If this is selected shape, then draw black outline.
        if (t == dBoard.getSelectedShape()) {
          g.setColor(Color.black);
          g.drawRect(t.upperLeftX, t.upperLeftY, t.height, t.height / 5);
          g.drawRect(t.upperLeftX + 2 * t.height / 5, t.upperLeftY + t.height / 5,
                     t.height / 5, 4 * t.height / 5);
          g.setColor(s.getColor());
          g.drawLine(t.upperLeftX + 2 * t.height / 5, t.upperLeftY + t.height / 5,
                     t.upperLeftX + 3 * t.height / 5, t.upperLeftY + t.height / 5);
        }
      }
    }
  }
}