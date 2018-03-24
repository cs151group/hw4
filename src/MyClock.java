import javax.swing.JLayeredPane;

public class MyClock extends JLayeredPane {

	//TODO: Should have 3 ClockHands, for hours, seconds minutes.
	//TODO: Should have 1 ClockFace.

	private JLayeredPane myClock;
	private ClockFace clockface;
	private ClockHand hand;

	  public MyClock(int x, int y, int width)
   {
	  myClock = new JLayeredPane();
	  clockface = new ClockFace(x, y, width);
	  hand = new ClockHand(1, 2, 3);


	  myClock.add(clockface);
	  myClock.add(hand);
	  clockface.repaint();
	  hand.repaint();


   }

}
