import java.awt.*;
import java.awt.geom.Line2D;

public class ClockHand implements MoveableShape, Stroke {
	
	//TODO: Add a timer

	/**
	 * Creates a ClockHand with length l, center (x, y), a width,
	 * and a Color. Starts the ClockHand in the 12 o'clock position.
	 * @param length The length of the line
	 * @param x the x position of the center
	 * @param y the y position of the center
	 * @param width the width of the line
	 * @param color the color of the line
	 */
	public ClockHand(int length, int x, int y,
						float width, Color color) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Shape createStrokedShape(Shape p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void translate(int dx, int dy) {
		// TODO Auto-generated method stub
		//x += dx;
        //y += dy;

	}
	
	/**
	 * Sets the angle of the circle.
	 * @param radians the angle of the circle
	 */
	// Should angles be counted clockwise or counterclockwise?
	// Angles should probably start from the 12 o'clock position.
	public void setAngle(double radians){
		
	}

	
	//I think this is how we draw, I pick 250 as the x1, x2, y2 
	//because I the circe is 500 but I don't know if that is radius or diameter
    //@Override
    public void paint(Graphics g) {
      Line2D shape = new Line2D.Double();
      shape.setLine(250, 20, 250, 250);  
      Graphics2D g2 = (Graphics2D) g; 
	  g2.setColor(Color.BLACK);
      g2.draw(shape);
   }
}
