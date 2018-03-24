import javax.swing.*;
import java.awt.*;

public class StopWatchDial extends JLayeredPane{
	private ClockFace face;
	private ClockHand hand;
	private int x;
	private int y;
	private int width;
	
	private static final double HAND_LENGTH = 0.8;
	// length of hand relative to radius
	
	public StopWatchDial(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.setLayout(new OverlayLayout(this));
		face = new ClockFace(x, y, width);
		int cX = x + width / 2;
		int cY = y + width / 2;
		hand = new ClockHand((int)((width / 2) * HAND_LENGTH), cX, cY, 2.0f, Color.BLACK);
 		this.add(face, new Integer(1));
		this.add(hand, new Integer(2));
		this.setPreferredSize(new Dimension(width, width));
		repaint();
	}

	public void updateHand(int position){
		double theta = ((double)position / 60) * 2 * Math.PI;
		hand.setAngle(theta);
	}
}
