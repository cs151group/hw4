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
		hours = new ClockHand(
				(int)((width / 2) * HOUR_RATIO),
				(x + width)/2,
				(y + width)/2,
				9.0f,
				Color.BLACK);
		mins = new ClockHand(
				(int)((width / 2) * MINUTE_RATIO),
				(x + width)/2,
				(y + width)/2,
				5.0f,
				Color.BLACK);
		this.setLayout(new OverlayLayout(this));
		this.add(clockface, JLayeredPane.DEFAULT_LAYER);
		this.add(seconds, new Integer(1));
		this.add(hours, new Integer(2));
		this.add(mins, new Integer(3));
		clockface.repaint();
		seconds.repaint();
		mins.repaint();
		hours.repaint();
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(width, width));
		
		//Setting up action listener
		ActionListener listener = event -> updateHands();
		t = new Timer(DELAY, listener);
		
		//Setting up from system time
		zdt = ZonedDateTime.now();
	}
	
	private void updateHands() {
		//Getting current time
		zdt = ZonedDateTime.now();
		
		int second = zdt.getSecond();
		double secondAngle = (double)(second / 60) * 2 * Math.PI;
		seconds.setAngle(secondAngle);
		seconds.repaint();
		
		int minute = zdt.getMinute();
		double minuteAngle = (double)(minute / 60) * 2 * Math.PI;
		mins.setAngle(minuteAngle);
		
		int hour = zdt.getHour();
		double hourAngle = (double)(hour / 12) * 2 * Math.PI;
		hours.setAngle(hourAngle);
	}
	
	private static final double SEC_RATIO = 0.85;
	private static final double MINUTE_RATIO = 0.80;
	private static final double HOUR_RATIO = 0.75;
	private static final int DELAY = 1000;
}
