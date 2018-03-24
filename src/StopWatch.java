import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StopWatch extends JLayeredPane {

    private StopWatchDial outerDial;
    private StopWatchDial innerDial;
    private int x;
    private int y;
    private int width;
    private Timer t;
    private long startTime;
    private long currentTime;
    private long elapsedTime;
    private long offset = 0;

    private static final double INNER_RATIO = 0.33;
    private static final double INNER_Y_OFFSET_RATIO = 0.1;

    public StopWatch(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        outerDial = new StopWatchDial(x, y, width);
        //TODO: figure out ratios for inner dial
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

    }


    /**
     * Starts the stopwatch.
     */
    public void start() {
        // XTODO Auto-generated method stub
        startTime = System.currentTimeMillis();

        //Setting up action listener
        ActionListener listener = event -> {
            currentTime = System.currentTimeMillis();
            elapsedTime = offset + (currentTime - startTime) / 1000;
            outerDial.updateHand((int) elapsedTime);
            innerDial.updateHand((int) elapsedTime / 60);
        };
        t = new Timer(DELAY, listener);
        t.start();
    }

    /**
     * Stops the stopwatch.
     */
    public void stop() {
        // XTODO Auto-generated method stub
        t.stop();
        offset = elapsedTime;
    }

    /**
     * Resets the stopwatch.
     */
    public void reset() {
        // TODO Fix reset
        t.restart();
        t.stop();
        outerDial.updateHand(0);
        innerDial.updateHand(0);
        offset = 0;
    }

    private static final double SEC_RATIO = 0.85;
    private static final int DELAY = 1000;
}
