import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.geom.Line2D;

public class ClockHand extends JComponent implements MoveableShape, Stroke {
	
	private int length; //should this be an int or a float? change if necessary
	private int centerX;
	private int centerY;
	private float width;
	private Color color;
	private float angle;

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
		// TODO Auto-generated constructor stub
	}

	public ClockHand(){
	  this.x = x;
      this.y = y;
   //   this.width = width;
      this.setOpaque(false);
 //     this.setPreferredSize(new Dimension(width, width));
		
	}

	public Shape createStrokedShape(Shape p) {
		// TODO Auto-generated method stub
		return null;
	}

	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
	  Line2D shape = new Line2D.Double();
      shape.setLine(250, 20, 250, 250);  
  //    Graphics2D g2 = (Graphics2D) g; 
	  g2.setColor(Color.BLACK);
      g2.draw(shape);

	}

	public void translate(int dx, int dy) {
		// TODO Auto-generated method stub
		x += dx;
        y += dy;

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
  /*/  @Override
    public void paint(Graphics g) {
      Line2D shape = new Line2D.Double();
      shape.setLine(250, 20, 250, 250);  
      Graphics2D g2 = (Graphics2D) g; 
	  g2.setColor(Color.BLACK);
      g2.draw(shape);
   } /*/
   
   private int x;
   private int y;
  // private int width;
}

