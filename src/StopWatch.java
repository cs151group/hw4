import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StopWatch extends JLayeredPane {

    public StopWatch(int x, int y, int width) {
        outerDial = new StopWatchDial(x, y, width);
        int innerX;
        int innerY;
        innerX = (int) ((width / 2) * 0.56);
        innerY = (int) ((width / 2) * 0.30);
        innerDial = new StopWatchDial(innerX, innerY, (int) (width * 0.45));
        this.setLayout(new OverlayLayout(this));
        this.setPreferredSize(new Dimension(width, width));
        this.add(outerDial, new Integer(1));
        this.add(innerDial, new Integer(2));
        repaint();
        elapsedTime = 0;
		offset = 0;
        isRunning = false;

        //Setting up action listener
        ActionListener listener = event -> {
            currentTime = System.currentTimeMillis();
            elapsedTime = offset + (currentTime - startTime) / 1000;
            outerDial.updateHand((int) elapsedTime);
            innerDial.updateHand((int) elapsedTime / 60);
        };
        t = new Timer(DELAY, listener);
    }

    /**
     * Starts the stopwatch.
     */
    public void start() {
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            t.start();
        }
        isRunning = true;
    }

    /**
     * Stops the stopwatch.
     */
    public void stop() {
        t.stop();
        offset = elapsedTime;
        isRunning = false;
    }

    /**
     * Resets the stopwatch.
     */
    public void reset() {
        t.restart();
        t.stop();
        outerDial.updateHand(0);
        innerDial.updateHand(0);
        elapsedTime = 0;
        offset = 0;
        isRunning = false;
    }

    private static final int DELAY = 1000;
    private StopWatchDial outerDial;
    private StopWatchDial innerDial;
    private Timer t;
    private long startTime;
    private long currentTime;
    private long elapsedTime;
    private long offset;
    private boolean isRunning;
}
