/*
 * Chun-Wei Chen
 * CSC142.04.F11
 * 2011/10/09
 * Assignment #2
 * This program is to use some of Java's graphics tools to --
 * 1. draw "square spiral" by using a loop
 * 2. design a sence which include at least three different "elements" 
 *    which require to write parameterized methods to draw these elements
 */

import java.awt.*;

public class drawingScene {
  public static void main(String[] args) {
    // Set up the DrawingPanel object and get a reference to its Graphics
    DrawingPanel dp = new DrawingPanel(500, 400);
    dp.setBackground(Color.WHITE);
    Graphics g = dp.getGraphics();

    squareSpiral(g, 0, 10, 160, 10); // draw spiral
      
    // initialize the location and the size of the tree
    int x = 60;
    int y = 400;
    int size = 190;
    
    // draw a series of 5 trees
    for(int i = 1; i < 6; i++) {
      tree(g, x, y, size);
      x += 100;
      y -= 60;
      size -= 30;
    }
    
    // draw two groups of odd trees
    oddTreeGroup(g, 220, 135, 120);
    oddTreeGroup(g, 360, 90, 80);
    
    // draw three buses
    bus(g, 240, 40, 80);
    bus(g, 155, 260, 160);
    bus(g, 370, 180, 120);
    
    // draw another tree and odd tree
    tree(g, 360, 400, 150);
    oddTree(g, 450, 390, 110);
    
    // show my name in the sence
    g.setColor(Color.BLACK);
    g.setFont(new Font("SanSerif", Font.BOLD, 16));
    g.drawString("Chun-Wei Chen", 380, 50);
  }
  
  public static void squareSpiral(Graphics g, int x1, int y1, int x2, int y2) {
    final int d = 10;  // store the distance between each arm of spiral
    g.setColor(Color.BLACK);
    g.drawLine(x1, y1, x2, y2);  // draw the first line od the spiral
    
    for (int i = x2 - x1 - d; i > 0; i -= 2 * d) {
      // use the loop to finish the rest of the spiral
      g.drawLine(x2, y2, x2, y2 + i);
      g.drawLine(x2, y2 + i, x2 - i, y2 + i);
      g.drawLine(x2 - i, y2 + i, x2 - i, y2 + d);
      g.drawLine(x2 - i, y2 + d, x2 - d, y2 + d);
      x2 -= d;
      y2 += d;
    }    
  }
  
  public static void bus(Graphics g, int x, int y, int size) {
    g.setColor(Color.BLACK);
    // draw the wheels
    g.fillOval(x + size / 8, y + 5 * size / 8, size / 4, size / 4);
    g.fillOval(x + 5 * size / 8, y + 5 * size / 8, size / 4, size / 4);
    g.setColor(Color.YELLOW);
    g.fillRect(x, y, size, 3 * size / 4); // draw the body
    drawWindow(g, x + size / 5, y + 3 * size / 16, 3 * size / 16);
    drawWindow(g, x + size / 2, y + 3 * size / 16, 3 * size / 16);
    // call drawWindow twice to draw two windows
    g.setColor(Color.WHITE);
    g.fillRect(x + 4 * size / 5, y + 3 * size / 8, size / 8, 3 * size / 8); // draw the door
    g.setColor(Color.BLACK);
    // draw the frame of the bus and the bus's door
    g.drawRect(x, y, size, 3 * size / 4);
    g.drawRect(x + 4 * size / 5, y + 3 * size / 8, size / 8, 3 * size / 8); 
  }
    
    public static void drawWindow(Graphics g, int x, int y, int size) {
      g.setColor(Color.WHITE);
      g.fillRect(x, y, size, size); // draw a window
      g.setColor(Color.BLACK);
      g.drawRect(x, y, size, size);
      // draw the frame of the window
      g.drawLine(x + size / 2, y, x + size / 2, y + size);
      g.drawLine(x, y + size / 2, x + size, y + size / 2);
    }
    
    public static void oddTree(Graphics g, int x, int y, int size) {
      g.setColor(new Color(153, 74, 0));
      // draw the trunk of the odd tree
      g.fillRect(x - size / 14, y - 2 * size / 5, size / 7, 2 * size / 5);
      g.setColor(Color.GREEN);
      // draw the crown of the odd tree
      g.fillOval(x - 2 *size / 9, y - size, 3 * size / 7, 7 * size / 10);
    }
    
    public static void oddTreeGroup(Graphics g, int x, int y, int size) {
      // group three odd trees together
      oddTree(g, x - size / 6, y - 2 * size / 5, size / 2);
      oddTree(g, x + size / 6, y - 3 * size / 5, 2 * size / 5);
      oddTree(g, x, y, 3 * size / 5);
    }
    
    public static void tree(Graphics g, int x, int y, int size) {
      g.setColor(new Color(153, 74, 0));
      g.fillRect(x - size / 12, y - size / 3, size / 6, size / 3); // draw the trunk
      
      // initialize the x- and y-coordinates for the traingle
      int x1 = x - size / 4;
      int y1 = y - size / 3;
      int x2 = x + size / 4;
      int y2 = y1;
      int x3 = x;
      int y3 = y - 2 * size / 3;
      
      // use for loop to draw three triangles
      for(int i = 1; i < 4; i++) {
        int[] xc = {x1, x2, x3}; // array of x-coordinates
        int[] yc = {y1, y2, y3}; // array of y-coordinates
        g.setColor(new Color(0, 143, 45));
        g.fillPolygon(xc, yc, 3); // draw the crown
        
        // update the y-coordinates
        y1 -= size / 5;
        y2 -= size / 5;
        y3 -= size / 5;
      }
    }
}