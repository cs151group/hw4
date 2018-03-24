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
//NO need to call ClockFace from here
//      ClockFace face = new ClockFace(0, 0, CLOCK_RADIUS);
	
	  StopWatch stopwatch = new StopWatch(0, 0, CLOCK_RADIUS);
      
      frame.setLayout(new BorderLayout());
      frame.add(clock, BorderLayout.CENTER);
      
      JPanel topNav = new JPanel(new FlowLayout());
	  JPanel lowNav = new JPanel();
	  
	  JButton clockButton = new JButton ("Clock");
	  
	  clockButton.addActionListener(event -> {
		frame.remove(stopwatch);
		frame.remove(lowNav);
		frame.add(clock, BorderLayout.CENTER);
		frame.pack();
	  });
		
		JButton stopwatchButton = new JButton ("Stopwatch");
		JButton stopButton = new JButton ("Stop");
		JButton startButton = new JButton ("Start");
		JButton resetButton = new JButton ("Reset");
		
		lowNav.add(startButton);
		lowNav.add(stopButton);
		lowNav.add(resetButton);
		
        stopwatchButton.addActionListener(event -> {
			frame.remove(clock);
			frame.add(stopwatch, BorderLayout.CENTER);
			frame.add(lowNav, BorderLayout.PAGE_END);
			frame.pack();
	  });

	  stopButton.addActionListener(event -> {
	  });
	  
	  startButton.addActionListener(event -> {
	  });
	  
	  resetButton.addActionListener(event -> {
	  });

	
      topNav.add(clockButton);
      topNav.add(stopwatchButton);
	  
      frame.add(topNav, BorderLayout.NORTH);
   //   clock.repaint();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      
   }

   private static final int CLOCK_RADIUS = 500;
}