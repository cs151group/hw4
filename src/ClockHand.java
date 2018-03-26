import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class ClockHand extends JComponent implements MoveableShape {
	
	private int length; 
	private int centerX;
	private int centerY;
	private float width;
	private Color color;
	private double endPointX;
	private double endPointY;

	/**
	 * Creates a ClockHand with length l, center (x, y), a width,
	 * and a Color. Starts the ClockHand in the 12 o'clock position.
	 * @param length The length of the line
	 * @param centerX the x position of the center
	 * @param centerY the y position of the center
	 * @param width the width of the line
	 * @param color the color of the line
	 */
	public ClockHand(int length, int centerX, int centerY,
						float width, Color color) {
		this.length = length;
		this.centerX = centerX;
		this.centerY = centerY;
		this.width = width;
		this.color = color;
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(length * 2, length * 2));
		this.endPointX = centerX;
		this.endPointY = centerY - length;
	}

	@Override
	public void draw(Graphics2D g2) {
	  Line2D shape = new Line2D.Double();
      shape.setLine(250, 20, 250, 250);
	  g2.setColor(Color.BLACK);
	  g2.setStroke(new BasicStroke(width));
      g2.draw(shape);
	}

	@Override
	public void translate(int dx, int dy) {
		this.centerX += dx;
        this.centerY += dy;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		Line2D line = new Line2D.Double();
		line.setLine(centerX, centerY, endPointX, endPointY);
		g2.setColor(color);
		g2.setStroke(new BasicStroke(width));
		g2.draw(line);
	}
	
	/**
	 * Sets the angle of the circle.
	 * All angles are relative to North (+y) being 0, 2pi
	 * @param radians the angle of the circle
	 */
	public void setAngle(double radians) {
		endPointX = (length * (Math.sin(radians))) + centerX;
		endPointY = (centerY - (length * Math.cos(radians)));
		this.repaint();
	}
}
