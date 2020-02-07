package abs.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends Shape {
	
	private static final long serialVersionUID = 2L;
	
	private int radius;
	private Color color;
	
	
	public Circle(int x, int y, int radius) {
		super(x, y);
		color 	= new Color(175, 0, 0);
		centerX = x - radius;
		centerY = y - radius;
	}

	public void draw(Graphics pencil) {
		pencil.setColor(color);
		pencil.fillOval(centerX, centerY, 2 * radius, 2 * radius);
	}
	
	public String toString() {
		return String.format("[%d]", radius);
	}
	
}
