import javax.swing.*;
import java.awt.*;

public class StopWatchDial extends JLayeredPane{
	private ClockFace face;
	private ClockHand hand;
	private int x;
	private int y;
	private int width;
	
	private static double HAND_LENGTH = 0.8;
	// length of hand relative to radius
	
	public StopWatchDial(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
		face = new ClockFace(x, y, width);
		int cX = x + width / 2;
		int cY = y + width / 2;
		hand = new ClockHand((int)(width / 2 * HAND_LENGTH), cX, cY);
		this.add(face, 1);
		this.add(hand, 2);
	}
}
