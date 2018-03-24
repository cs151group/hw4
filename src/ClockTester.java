import java.awt.*;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class ClockTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      //TODO: Modify ClockTester to work with MyClock and Stopwatch. 
      

      MyClock clock = new MyClock(0, 0, CLOCK_RADIUS);

      ClockFace face = new ClockFace(0, 0, CLOCK_RADIUS);

      
      frame.setLayout(new BorderLayout());
      frame.add(clock, BorderLayout.CENTER);
      
      JPanel topNav = new JPanel(new FlowLayout());
      topNav.add(new JButton("clock"));
      topNav.add(new JButton("stopwatch"));
      frame.add(topNav, BorderLayout.NORTH);
      clock.repaint();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      
   }

   private static final int CLOCK_RADIUS = 500;
}