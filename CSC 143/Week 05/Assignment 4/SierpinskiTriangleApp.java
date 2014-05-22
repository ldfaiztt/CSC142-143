import java.awt.*;
import javax.swing.*;

/**
 * This class hooks up the model, viewers and controller, and then displays views in
 * a window. User can use the button to increase and decrease the level of the
 * SierpinskiTriangleApp.
 * @author Chun-Wei Chen
 * @version 02/12/12
 */
public class SierpinskiTriangleApp
{   
  /**
   * Setup window to display the SierpinskiTriangle project.
   * @param args
   */
  public static void main(String[] args) {
    // Setup window
    JFrame win = new JFrame("Sierpinski's Triangle");
    
    // Set the default close operation
    win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Construct the model of the SierpinskiTriangle
    SierpinskiTriangleModel model = new SierpinskiTriangleModel(175, 10, 256);
    // Add graphical view to the window
    win.getContentPane().add(new SierpinskiTriangleGraphicView(model, Color.BLUE, 350, 300),
                             BorderLayout.CENTER);
    // Add controller, includes button and text view, to the window 
    win.getContentPane().add(new SierpinskiTriangleController(model), BorderLayout.SOUTH);
    
    win.pack(); // Lay out components and resize window to fit
    win.setVisible(true); // Let the window become visible
  }
}