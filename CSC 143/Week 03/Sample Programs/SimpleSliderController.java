import javax.swing.*;
import javax.swing.event.*;

public class SimpleSliderController implements ChangeListener
{
  private JSlider source;
 
  public SimpleSliderController (JSlider s) {
    source = s;
    source.addChangeListener(this);
  } 
 
     // try this method with and without the 'if' statement limiting what is printed
  public void stateChanged(ChangeEvent e) {
    if (!source.getValueIsAdjusting()) {
      System.out.println(source.getValue());
    }
  }
}