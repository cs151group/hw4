import javax.swing.*;
import java.awt.*;

public class MyClock extends JLayeredPane {

	// TODO: Should have 3 ClockHands, for hours, seconds minutes.
	// TODO: Should have 1 ClockFace.
	// private ClockHand hours;
	// private ClockHand mins;
	// private ClockHand secs;
	// private ClockFace face;

	private ClockFace clockface;
	private ClockHand seconds;

	public MyClock(int x, int y, int width) {
		clockface = new ClockFace(x, y, width);
		seconds = new ClockHand(
				(int)((width / 2) * SEC_RATIO), 
				(x + width)/2, 
				(y + width)/2, 
				2.0f, 
				Color.RED );
		this.setLayout(new OverlayLayout(this));
		this.add(clockface, JLayeredPane.DEFAULT_LAYER);
		this.add(seconds, new Integer(2));
		clockface.repaint();
		seconds.repaint();
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(width, width));
	}
	private static final double SEC_RATIO = 0.85;
}
