import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;

public class MyClock extends JLayeredPane {

	private ClockFace clockface;
	private ClockHand seconds;
	private ClockHand hours;
	private ClockHand mins;
	private ZonedDateTime zdt;
	private Timer t;

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
		
		//Setting up action listener
		ActionListener listener = event -> updateHands();
		t = new Timer(DELAY, listener);
		
		//Setting up from system time
		zdt = ZonedDateTime.now();
	}
	
	private void updateHands() {
		zdt = ZonedDateTime.now();
		int second = zdt.getSecond();
		double secondAngle = (double)(second / 60) * 2 * Math.PI;
		seconds.setAngle(secondAngle);
		seconds.repaint();
		
		int minute = zdt.getMinute();
		int hour = zdt.getHour();
	}
	
	private static final double SEC_RATIO = 0.85;
	private static final int DELAY = 1000;
}
