import java.awt.*;
import javax.swing.*;

/**
 * A Smiley-face panel.  CSE143 lecture demo, Au01, Sp03
 * 
 * @author Hal Perkins, VO
 * @version 10/16/01, 4/14/03, 4/7/04; 1/17/05 by VO
 */
public class Face extends JPanel {
  
  /** Paint a smiley face centered in this Jpanel */
  public void paintComponent( Graphics g ) {
    // Note: The drawing code here uses the original AWT methods.
    // A version that used the newer Graphics2D package would include
    // Graphics2D g2 = (Graphics2D)g;
    // then add shapes to the picture using g2.
    
    // paint background
    super.paintComponent( g );
  
    // get width and height of drawing area
    int height = getHeight( );
    int width  = getWidth( );
    
    // draw face that takes up 80% of the JPanel
    int faceTop  = height/10;
    int faceLeft = width/10;
    int faceHeight = height - height/5;
    int faceWidth  = width  - width/5;
    
    // outline
    g.setColor( Color.yellow );
    g.fillOval( faceLeft, faceTop, faceWidth, faceHeight );
    
    // eyes
    g.setColor( Color.black );
    g.fillOval( faceLeft + (int)(width*0.2), faceTop + (int)(height*0.2),
                width/10, height/10);
    g.fillOval( faceLeft + (int)(width*0.5), faceTop + (int)(height*0.2),
                width/10, height/10);
    
    // nose
    Polygon nose = new Polygon( );
    nose.addPoint( faceLeft+(int)(width*0.40), faceTop+(int)(height*0.35) );
    nose.addPoint( faceLeft+(int)(width*0.45), faceTop+(int)(height*0.50) );
    nose.addPoint( faceLeft+(int)(width*0.35), faceTop+(int)(height*0.50) );
    g.fillPolygon( nose );
    
    // mouth
    g.fillArc( faceLeft+(int)(width*0.25), faceTop+(int)(height*0.5),
               (int)(width*0.3), (int)(height*0.2),
               0, -180);
  }
}
