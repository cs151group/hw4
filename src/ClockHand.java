import java.awt.*;
import java.awt.geom.Line2D;

public class ClockHand implements MoveableShape, Stroke {
	
	//TODO: Add a timer

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
