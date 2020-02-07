package abs.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {

	private static final long serialVersionUID = 2L;
	
	private int centerX, centerY;
	private int height;
	private int width;
	private Color color;
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		color 	= Color.RED;
		centerX = x - width / 2;
		centerY = y - height / 2;
	}
	
	public void draw(Graphics pencil) {
		pencil.setColor(color);
		pencil.fillRect(centerX, centerY, width, height);
	}
	
	public String toString() {
		return String.format("[%d, %d]", width, height);
	}
}
