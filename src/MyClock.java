import javax.swing.*;
import java.awt.*;

public class MyClock extends JPanel {

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
				(int)(width * SEC_RATIO), 
				(x + width)/2, 
				(y + width)/2, 
				3.0f, 
				Color.RED );

		this.add(clockface);
		this.add(seconds);
		clockface.repaint();
		seconds.repaint();
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(width, width));
	}
	private static final double SEC_RATIO = 0.85;
}
