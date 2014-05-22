import java.awt.*;

/**
 * This class demonstrates the use of the graphics tools in Java.  To use
 * it, place TestDP.java in a folder along with the file DrawingPanel.java
 * available on the text book's companion web site in the "Supplements" 
 * area.  You do not need to open the DrawingPanel code in DrJava for it
 * to work.  Other development environments may work differently; contact
 * your instructor if you have questions.
 * 
 * This class also demonstrates the use of a parameterized method named
 * drawIndonesianFlag() that draws a scaled version of the flag every
 * time it is called.  Notice how this makes it easy to create a complex
 * drawing with a modest amount of code.
 */
public class TestDP
{
  /**
   * This 'main' method creates a drawing panel and draws a scene in it.
   */
  public static void main( String[] args ) {
    // Set up the DrawingPanel object and get a reference to its Graphics
    DrawingPanel dp = new DrawingPanel( 350, 200);
    dp.setBackground( Color.LIGHT_GRAY );
    Graphics dpg = dp.getGraphics();
    
    // Draw one large flag
    drawIndonesianFlag( dpg, 10, 104, 80 );
    
    // Draw a series of 7 smaller flags
    for ( int i = 0; i < 7; i++ ) {
      int scaleFactor = (i-2)*(i-2);  
      drawIndonesianFlag( dpg, 10 + 45 * i, 20 + 8 * scaleFactor, 20 + scaleFactor );
    }
    
    // More advanced -- beyond what we have covered so far...
    // Draw a blue triangle by using the fillPolygon method
    // Pass in two ARRAYS -- sets of x- and y-coordinates
    // Refer to the Java API documentation for more information
    int[] xc = {180, 190, 200}; // array of x-coordinates
    int[] yc = {180, 200, 180}; // array of y-coordinates
    dpg.setColor(Color.BLUE);
    dpg.fillPolygon(xc, yc, 3);
  }
  
  /**
   * This method draws an Indonesian flag at a location defined by x and y and 
   * with the specified height.  The width of the flag is 1.5 times the height.
   * If the height provided is an odd number, it will be reduced by 1 so that
   * it is an even number; this ensures that the flag is symetrical.  The 
   * drawing is performed on the Graphics context provided in the first parameter.
   * The location of the flag is specified with respect to the upper-left corner
   * of the drawing panel.
   * 
   * @param g the Graphics context to use for the drawing
   * @param x the x-coordinate of the upper-left corner of the flag in pixels
   * @param y the y-coordinate of the upper-left corner of the flag in pixels
   * @param height the height the flag in pixels
   */
  public static void drawIndonesianFlag( Graphics g, int x, int y, int height ) {
    // make sure height is an even number
    height = height - height % 2;
    
    int width = height * 3 / 2;
    
    // draw flag in 3 steps: red bar, white bar and border
    g.setColor( Color.RED );
    g.fillRect( x, y, width, height / 2 );
    g.setColor( Color.WHITE );
    g.fillRect( x, y + height / 2, width, height / 2 );
    g.setColor( Color.BLACK );
    g.drawRect( x, y, width, height );
  }
}

/*
 * DrawingPanel methods:
 *   Graphics getGraphics()
 *   void setBackground(Color c)
 * 
 * Graphics methods:
 *   void drawLine(int x1, int y1, int x2, int y2)
 *   void drawOval(int x, int y, int width, int height)
 *   void drawRect(int x, int y, int width, int height)
 *   void fillOval(int x, int y, int width, int height)
 *   void fillRect(int x, int y, int width, int height)
 *   void drawString(String message, int x, int y)
 *   void setColor(Color c)
 *   void setFont( ... ) [see info in the text beginning on page 202]
 * 
 * Other:
 *   custom colors [see info in the text on page 201]
 *   custom fonts [see info in the text beginning on page 202]
 */