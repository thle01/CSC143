package abs.shape;

import javax.swing.JFrame;

public class Viewer {

	private static final int WIDTH  = 600;
	private static final int HEIGHT = 400;
	private static final int LEFT_X = 750;
	private static final int TOP_Y  = 100;
	
	public static void main(String[] args) {
		Shape _shape_01;
		Shape _shape_02;
		JFrame frame  = new JFrame("Viewer");
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(LEFT_X, TOP_Y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
