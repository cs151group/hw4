import java.awt.*;  //Mocha for Micah
import javax.swing.*;

/**
   This program implements an analog clock and stopwatch.
*/
public class ClockTester {
    public static void main(String[] args) {
        MyClock clock = new MyClock(0, 0, CLOCK_RADIUS);
        StopWatch watch = new StopWatch(0, 0, CLOCK_RADIUS);

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        JPanel topNav = new JPanel(new FlowLayout());
        frame.add(topNav, BorderLayout.NORTH);
        
        //On program start, clock is showing
        frame.add(clock, BorderLayout.CENTER);
        
        JButton clockButton = new JButton("Clock");
        JButton stopwatchButton = new JButton("Stopwatch"); 
        
        topNav.add(clockButton);
        topNav.add(stopwatchButton);

        JButton stopButton = new JButton("Stop");
        JButton startButton = new JButton("Start");
        JButton resetButton = new JButton("Reset");
        
        JPanel lowNav = new JPanel();
        lowNav.add(startButton);
        lowNav.add(stopButton);
        lowNav.add(resetButton);
    
        clockButton.addActionListener(event -> {
            frame.remove(watch);
            frame.remove(lowNav);
            frame.add(clock, BorderLayout.CENTER);
            frame.pack();
        });

        stopwatchButton.addActionListener(event -> {
            frame.remove(clock);
            frame.add(watch, BorderLayout.CENTER);
            frame.add(lowNav, BorderLayout.PAGE_END);
            frame.pack();
        });
        
        stopButton.addActionListener(event -> watch.stop());
        startButton.addActionListener(event -> watch.start());
        resetButton.addActionListener(event -> watch.reset());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static final int CLOCK_RADIUS = 500;

}