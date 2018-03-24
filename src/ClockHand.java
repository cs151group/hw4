import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.geom.Line2D;

public class ClockHand extends JComponent implements MoveableShape, Stroke {
	
	//TODO: Add a timer

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
	//
	
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

