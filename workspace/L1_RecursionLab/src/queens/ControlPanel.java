package queens;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = 5L;
	private static final int SIZE = 4;
	private String imageLocation;
	private ImageIcon queenIcon;
	private Image queenImage;
	private int[] rowPositions;
	private int startingColumn;

	public ControlPanel() {
		this(0);
	}

	public ControlPanel(int start) {
		startingColumn = start;
		imageLocation = "images" + File.separator + "queen.jpg";
		queenIcon = new ImageIcon(imageLocation);
		queenImage = queenIcon.getImage();
		rowPositions = new int[SIZE];

	}

	public void draw(Graphics _graphics) {
//		if (search(0, startingColumn)) {
		if (search(0)) {
			drawQueens(_graphics);
			drawChessBoard(_graphics);
		}
	}

	public void drawChessBoard(Graphics _graphics) {
		for (int i = 0; i < SIZE; i++) {
			_graphics.drawLine(0, i * getHeight() / SIZE, getWidth(), i * getHeight() / SIZE);
			_graphics.drawLine(i * getWidth() / SIZE, 0, i * getWidth() / SIZE, getHeight());
		}
	}

	public void drawQueens(Graphics _graphics) {
		int j; // position of queen in row i
		int imageX = 0;
		int imageY = 0;
		int imageWidth = 0;
		int imageHeight = 0;

		if (queenImage != null) {
			for (int i = 0; i < SIZE; i++) {
				j = rowPositions[i];
				imageX = j * getWidth() / SIZE;
				imageY = i * getHeight() / SIZE;
				imageWidth = getWidth() / SIZE;
				imageHeight = getHeight() / SIZE;
				_graphics.drawImage(queenImage, imageX, imageY, imageWidth, imageHeight, this);
			}
		}
	}

	public void paintComponent(Graphics _graphics) {
		super.paintComponent(_graphics);
		draw(_graphics);
	}

	/************************************************************
	 * checks if a queen can be placed in row and column
	 **********************************************************/
	public boolean isSafe(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (rowPositions[i] == col)
				return false;

			if (Math.abs(i - row) == Math.abs(rowPositions[i] - col))
				return false;
		}
		return true;
	}

	/************************************************************
	 * search for a solution starting from a specified column in the first row.
	 **********************************************************/
	public boolean search(int row) {
		if (row == SIZE)
			return true;

		boolean allQueensPlaced = false;

		for (int col = 0; col < SIZE; col++) {
			printBoard(rowPositions);
			rowPositions[row] = col;

			if (isSafe(row, col)) {
				allQueensPlaced = search(row + 1);		
			}
			if (allQueensPlaced)
				return true;
		}
		//how can we stop recursive at row 0 and add parameter start

		return false;
	}

	private static void printBoard(int[] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (j == board[i]) {
					System.out.print("Q ");
				} else {
					System.out.print("_ ");
				}
			}
			System.out.println();
		}
		System.out.println("**********");
	}
}
