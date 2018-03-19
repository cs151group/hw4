import javax.swing.*;
import java.awt.*;

public class StopWatch extends JLayeredPane{

	private StopWatchDial outer;
	private StopWatchDial inner;
	private int x;
	private int y;
	private int width;

	private static final double INNER_RATIO = 0.33;
	private static final double INNER_Y_OFFSET_RATIO = 0.1;

	public StopWatch (int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
		outer = new StopWatchDial(x, y, width);
		//TODO: figure out ratios for inner dial
	}
	
	/**
	 * Starts the stopwatch.
	 */
	private void start() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Stops the stopwatch.
	 */
	private void stop() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Resets the stopwatch.
	 */
	private void reset() {
		// TODO Auto-generated method stub
	}
}
