import java.awt.*;
import javax.swing.*;

public class SliderTestPanel extends JPanel {
 
  private static final int MIN = 0, MAX = 100, INITIAL = 50;
 
  public SliderTestPanel() {
    JSlider slider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INITIAL);
    slider.setMajorTickSpacing(20);
    slider.setPaintTicks(true);
    
    SimpleSliderController cont = new SimpleSliderController(slider);
    
    this.add(slider);
  }
 
  public static void main(String[] args) {
    JFrame frame = new JFrame("Test Panel Window");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    SliderTestPanel panel = new SliderTestPanel();
    panel.setPreferredSize(new Dimension(200,50));
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}