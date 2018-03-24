<<<<<<< HEAD
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

public class MyClock extends JLayeredPane {
=======
import javax.swing.*;
import java.awt.*;

public class MyClock {
	
	//TODO: Should have 3 ClockHands, for hours, seconds minutes.
	//TODO: Should have 1 ClockFace.
	
//	private JLayeredPane myclock;
	private ClockFace clockface;
	private ClockHand hand;
	
	  public MyClock(int x, int y, int width)
   {
//	  myclock = new JLayeredPane();
	  clockface = new ClockFace(x, y, width);
	  hand = new ClockHand();
	  
	  
	  this.add(clockface);
	  this.add(hand);
	  clockface.repaint();
	  hand.repaint();
	  
	  
   }

}
