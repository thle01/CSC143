package abs.shape;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public abstract class Shape extends JPanel{
	
	private static final long serialVersionUID = 5L;
	
	protected int centerX, centerY;
	protected int x;		// top left x
	protected int y;		// top left y
	
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void draw(Graphics pencil);
	
	public Point getCenter() {
		return new Point(centerX, centerY);
	}
	
	public void paintComponent(Graphics pencil) {
		super.paintComponent(pencil);
	}
	
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}

}
