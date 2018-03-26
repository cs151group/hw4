import java.awt.*;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class ClockHand extends JComponent implements MoveableShape {
	
	private int length; //should this be an int or a float? change if necessary
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
		// TODO Auto-generated constructor stub
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

	
	/**
	 * Creates a ClockHand with length l and center (x, y). Width and color are set
	 * to default values. Starts the ClockHand in the 12 o'clock position.
	 * 
	 * @param length
	 * @param x
	 * @param y
	 */
	public ClockHand(int length, int x, int y) {
		// XTODO Auto-generated constructor stub
		this.length = length;
		this.centerX = x;
		this.centerY = y;
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
	  Line2D shape = new Line2D.Double();
      shape.setLine(250, 20, 250, 250);
  //    Graphics2D g2 = (Graphics2D) g;
	  g2.setColor(Color.BLACK);
	  g2.setStroke(new BasicStroke(width));
      g2.draw(shape);

	}

	@Override
	public void translate(int dx, int dy) {
		// TODO Auto-generated method stub
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
