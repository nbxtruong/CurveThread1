import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/** D'après Jean Brondeau */

public abstract class Curve extends Thread {

	protected double position;

	protected int speed;

	protected Graphics2D graphics;
	
	protected int width;

	public Curve(int speed, Graphics2D g, int width) {
		this.speed = speed;
		this.graphics = g;
		this.width = width;
		position = 0.;
	}

	public void run() {
		int period = 100 / speed;
		double yp = function(position);
		Line2D line = new Line2D.Double();
		while (position < width) {
			try {
				sleep(period);
				position++;
				double y = function(position);
				line.setLine(position - 1, yp, position, y);
				graphics.draw(line);
				yp = y;
			} catch (InterruptedException e) {
			}
		}
	}

	public abstract double function(double x);

}
