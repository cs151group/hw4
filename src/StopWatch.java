import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.ZonedDateTime;

public class StopWatch extends JLayeredPane{

	private StopWatchDial outer;
	private StopWatchDial inner;
	private int x;
	private int y;
	private int width;
	private Timer t;
	private long startTime;
	private long currentTime;
	private long elapsedTime;
	private StopWatchDial secDial;

	private static final double INNER_RATIO = 0.33;
	private static final double INNER_Y_OFFSET_RATIO = 0.1;

	public StopWatch (int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
		outer = new StopWatchDial(x, y, width);
		//TODO: figure out ratios for inner dial
		int innerX;
		int innerY;
		innerX = (int)((width / 2) * 0.70);
		innerY = (int)((width / 2) * 0.30);
		inner = new StopWatchDial(innerX, innerY, width);

		this.setLayout(new OverlayLayout(this));
		this.setPreferredSize(new Dimension(width, width));
		this.add(outer, new Integer(1));
		repaint();

	}


	/**
	 * Starts the stopwatch.
	 */
	private void start() {
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();

		//Setting up action listener
		ActionListener listener = event -> {
			currentTime = System.currentTimeMillis();
			elapsedTime = currentTime - startTime;
			secDial.updateHand((int)elapsedTime);
		};
		t = new Timer(DELAY, listener);
		t.start();
	}
	
	/**
	 * Stops the stopwatch.
	 */
	private void stop() {
		// TODO Auto-generated method stub
		t.stop();
	}
	
	/**
	 * Resets the stopwatch.
	 */
	private void reset() {
		// TODO Auto-generated method stub
		t.restart();
		t.stop();
	}
	private static final double SEC_RATIO = 0.85;
	private static final int DELAY = 1000;
}
